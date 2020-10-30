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
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

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
        Long formUserId = rootRequest.getFormUserId();
        if (formUserId != null) {
            UserBaseInfo userBaseInfo = userBaseInfoService.getUserBaseInfoById(formUserId);
            if (userBaseInfo == null || userBaseInfo.getUserStatus() == BaseStateEnum.DISABLE.value()) {
                LOGGER.error("操作失败！评论者在系统不存在或已被禁用！formUserId:{} ", formUserId);
                throw new BizRtException("操作失败！评论者在系统不存在或已被禁用！");
            }
            rootRequest.setFromUserName(userBaseInfo.getNickname());
            rootRequest.setFromUserEmail("管理员");
        }

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
        Long replyUserId = replyRequest.getReplyUserId();
        if (replyUserId != null) {
            UserBaseInfo userBaseInfo = userBaseInfoService.getUserBaseInfoById(replyUserId);
            if (userBaseInfo == null || userBaseInfo.getUserStatus() == BaseStateEnum.DISABLE.value()) {
                LOGGER.error("操作失败！评论者在系统不存在或已被禁用！formUserId:{} ", replyUserId);
                throw new BizRtException("操作失败！评论者在系统不存在或已被禁用！");
            }
            replyRequest.setReplyUserName(userBaseInfo.getNickname());
            replyRequest.setReplyUserEmail("管理员");
        }
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

        IPage<CommentRoot> page = new Page<>(condition.getPage(), condition.getPageSize());
        if (condition.getOwnerId() != null) {
            queryWrapper.eq(CommentRoot::getOwnerId, condition.getOwnerId());
        }
        queryWrapper.eq(CommentRoot::getOwnerType, condition.getOwnerType());
        queryWrapper.eq(CommentRoot::getState, BaseStateEnum.ENABLE.value());
        queryWrapper.orderByDesc(CommentRoot::getCreateTime);

        return commentRootMapper.selectPage(page, queryWrapper);
    }

    @Override
    public IPage<CommentReply> queryCommentReplyList(QueryCommentReplyCondition condition) {
        LambdaQueryWrapper<CommentReply> queryWrapper = new LambdaQueryWrapper<>();

        IPage<CommentReply> page = new Page<>(condition.getPage(), condition.getPageSize());
        queryWrapper.eq(CommentReply::getCommentRootId, condition.getCommentRootId());
        // queryWrapper.eq(CommentReply::getReplyUserId, condition.getReplyUserId());
        queryWrapper.eq(CommentReply::getReplyState, BaseStateEnum.ENABLE.value());
        queryWrapper.orderByDesc(CommentReply::getCreateTime);

        return commentReplyMapper.selectPage(page, queryWrapper);
    }

    @Override
    public int getCommentNum(Integer ownerType, Long ownerId) {
        int commentNum = 0;

        List<CommentRoot> commentRootList = commentRootMapper
            .selectList(new LambdaQueryWrapper<CommentRoot>().eq(CommentRoot::getState, BaseStateEnum.ENABLE.value())
                .eq(CommentRoot::getOwnerType, ownerType).eq(CommentRoot::getOwnerId, ownerId));

        if (!CollectionUtils.isEmpty(commentRootList)) {
            commentNum += commentRootList.size();
            for (CommentRoot commentRoot : commentRootList) {
                Integer count = commentReplyMapper.selectCount(
                    new LambdaQueryWrapper<CommentReply>().eq(CommentReply::getReplyState, BaseStateEnum.ENABLE.value())
                        .eq(CommentReply::getCommentRootId, commentRoot.getCommentId()));
                commentNum += Optional.ofNullable(count).orElse(0);
            }
        }

        return commentNum;
    }

    @Override
    public Map<Long, Integer> getCommentNumMap(Integer ownerType, List<Long> ownerIds) {
        Map<Long, Integer> map = new HashMap<>();

        List<CommentRoot> commentRootList = commentRootMapper
            .selectList(new LambdaQueryWrapper<CommentRoot>().eq(CommentRoot::getState, BaseStateEnum.ENABLE.value())
                .eq(CommentRoot::getOwnerType, ownerType).in(CommentRoot::getOwnerId, ownerIds));

        if (!CollectionUtils.isEmpty(commentRootList)) {
            // 根据对象id分组
            Map<Long, List<CommentRoot>> listMap =
                commentRootList.stream().collect(Collectors.groupingBy(CommentRoot::getOwnerId));

            for (Map.Entry<Long, List<CommentRoot>> entry : listMap.entrySet()) {
                Long key = entry.getKey();
                List<CommentRoot> value = entry.getValue();

                // 获取每个对象的总评论数
                int commentNum = value.size();
                for (CommentRoot commentRoot : value) {
                    Integer count = commentReplyMapper.selectCount(new LambdaQueryWrapper<CommentReply>()
                        .eq(CommentReply::getReplyState, BaseStateEnum.ENABLE.value())
                        .eq(CommentReply::getCommentRootId, commentRoot.getCommentId()));
                    commentNum += Optional.ofNullable(count).orElse(0);
                }

                map.put(key, commentNum);
            }
        }

        return map;
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
