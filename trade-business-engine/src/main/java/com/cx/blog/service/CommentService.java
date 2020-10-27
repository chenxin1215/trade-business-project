package com.cx.blog.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.blog.dao.comment.CommentReplyMapper;
import com.cx.blog.dao.comment.CommentRootMapper;
import com.cx.blog.dto.request.comment.AddCommentReplyRequest;
import com.cx.blog.dto.request.comment.AddCommentRootRequest;
import com.cx.blog.dto.request.comment.QueryCommentReplyCondition;
import com.cx.blog.dto.request.comment.QueryCommentRootCondition;
import com.cx.blog.entity.comment.CommentReply;
import com.cx.blog.entity.comment.CommentRoot;
import com.cx.blog.enums.BaseStateEnum;
import com.cx.user.entity.UserBaseInfo;
import com.cx.user.service.IAPIUserBaseInfoService;
import com.cx.utils.exception.BizRtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * <评论接口>
 *
 * @Author: chenxin
 * @Date: 2020/10/27
 */
@Service
public class CommentService implements IAPICommentService {

    private static Logger LOGGER = LoggerFactory.getLogger(CommentService.class);

    @Autowired
    private SensitiveService sensitiveService;

    @Autowired
    private CommentRootMapper commentRootMapper;

    @Autowired
    private CommentReplyMapper commentReplyMapper;

    @Reference
    private IAPIUserBaseInfoService userBaseInfoService;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Override
    public Long addCommentRoot(AddCommentRootRequest rootRequest) {
        String fromUserName = rootRequest.getFromUserName();
        String commentContent = rootRequest.getCommentContent();

        // 检查评论信息
        checkCommentInfo(fromUserName, commentContent);

        CommentRoot insertComment = new CommentRoot();
        BeanUtils.copyProperties(rootRequest, insertComment);
        insertComment.setCommentTime(new Date());
        commentRootMapper.insert(insertComment);

        return insertComment.getCommentId();
    }

    @Override
    public Long addCommentReply(AddCommentReplyRequest replyRequest) {
        String replyUserName = replyRequest.getReplyUserName();
        String replyContent = replyRequest.getReplyContent();

        // 检查评论信息
        checkCommentInfo(replyUserName, replyContent);

        CommentReply insertReply = new CommentReply();
        BeanUtils.copyProperties(replyRequest, insertReply);
        insertReply.setReplyTime(new Date());
        commentReplyMapper.insert(insertReply);

        // 创建线程发送短信提醒
        taskExecutor.execute(() -> LOGGER.info("发送短信。。。"));

        return insertReply.getId();
    }

    @Override
    @Transactional
    public void deleteCommentRoot(Long id, Long operationUserId) {
        checkDeleteRequest(id, operationUserId);

        CommentRoot commentRoot = commentRootMapper.selectById(id);
        if (commentRoot == null) {
            LOGGER.error("操作失败，评论不存在 id:{}", id);
            throw new BizRtException("操作失败，评论不存在");
        }

        // 删除评论
        commentRoot.setState(BaseStateEnum.DISABLE.value());
        commentRootMapper.updateById(commentRoot);

        // 删除对应评论回复
        CommentReply commentReply = new CommentReply();
        commentReply.setReplyState(BaseStateEnum.DISABLE.value());
        commentReplyMapper.update(commentReply,
            new LambdaQueryWrapper<CommentReply>().eq(CommentReply::getCommentRootId, id));

    }

    @Override
    public void deleteCommentReply(Long id, Long operationUserId) {
        checkDeleteRequest(id, operationUserId);

        CommentReply commentReply = commentReplyMapper.selectById(id);
        if (commentReply == null) {
            LOGGER.error("操作失败，评论不存在 id:{}", id);
            throw new BizRtException("操作失败，评论不存在");
        }

        // 删除评论回复
        commentReply.setReplyState(BaseStateEnum.DISABLE.value());
        commentReplyMapper.updateById(commentReply);

    }

    @Override
    public IPage<CommentRoot> queryCommentRootList(QueryCommentRootCondition condition) {
        LambdaQueryWrapper<CommentRoot> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(CommentRoot::getOwnerId, condition.getOwnerId());
        queryWrapper.eq(CommentRoot::getOwnerType, condition.getOwnerType());
        queryWrapper.eq(CommentRoot::getState, BaseStateEnum.ENABLE.value());
        queryWrapper.orderByDesc(CommentRoot::getCreateTime);

        return commentRootMapper.selectPage(new Page<>(condition.getPage(), condition.getPageSize()), queryWrapper);
    }

    @Override
    public IPage<CommentReply> queryCommentReplyList(QueryCommentReplyCondition condition) {
        LambdaQueryWrapper<CommentReply> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(CommentReply::getCommentRootId, condition.getCommentRootId());
        queryWrapper.eq(CommentReply::getReplyUserId, condition.getReplyUserId());
        queryWrapper.eq(CommentReply::getReplyState, BaseStateEnum.ENABLE.value());
        queryWrapper.orderByDesc(CommentReply::getCreateTime);

        return commentReplyMapper.selectPage(new Page<>(condition.getPage(), condition.getPageSize()), queryWrapper);
    }

    private void checkDeleteRequest(Long id, Long operationUserId) {
        Assert.notNull(id, "id is cant be null");
        Assert.notNull(operationUserId, "operationId is cant be null");

        UserBaseInfo operationUser = userBaseInfoService.getUserBaseInfoById(operationUserId);
        if (operationUser == null) {
            LOGGER.error("操作失败，操作人不存在于系统 operationUserId:{}", operationUserId);
            throw new BizRtException("操作失败，操作人不存在于系统");
        }
    }

    private void checkCommentInfo(String fromUserName, String commentContent) {
        if (fromUserName.length() > 8) {
            throw new BizRtException("操作失败！昵称长度不能超过8个字符！当前:" + fromUserName.length());
        }
        if (!sensitiveService.isSensitiveStr(fromUserName)) {
            throw new BizRtException("操作失败！昵称包含敏感字符！");
        }
        if (!sensitiveService.isSensitiveStr(commentContent)) {
            throw new BizRtException("操作失败！评论内容包含敏感字符！");
        }
    }
}
