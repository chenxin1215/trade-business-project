package com.cx.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cx.blog.dto.request.comment.AddCommentReplyRequest;
import com.cx.blog.dto.request.comment.AddCommentRootRequest;
import com.cx.blog.dto.request.comment.QueryCommentReplyCondition;
import com.cx.blog.dto.request.comment.QueryCommentRootCondition;
import com.cx.blog.entity.comment.CommentReply;
import com.cx.blog.entity.comment.CommentRoot;

public interface IAPICommentService {

    /**
     * 功能描述: 新增主评论
     *
     * @Author: chenxin
     * @Param: [rootRequest]
     * @Date: 2020/10/27
     */
    Long addCommentRoot(AddCommentRootRequest rootRequest);

    /**
     * 功能描述: 新增评论回复
     *
     * @Author: chenxin
     * @Param: [replyRequest]
     * @Date: 2020/10/27
     */
    Long addCommentReply(AddCommentReplyRequest replyRequest);

    /**
     * 功能描述: 删除主评论
     *
     * @Author: chenxin
     * @Param: [id,operationUserId]
     * @Date: 2020/10/27
     */
    void deleteCommentRoot(Long id, Long operationUserId);

    /**
     * 功能描述: 删除评论回复
     *
     * @Author: chenxin
     * @Param: [id,operationUserId]
     * @Date: 2020/10/27
     */
    void deleteCommentReply(Long id, Long operationUserId);

    /**
     * 功能描述: 查询主评论列表
     *
     * @Author: chenxin
     * @Param: [condition]
     * @Date: 2020/10/27
     */
    IPage<CommentRoot> queryCommentRootList(QueryCommentRootCondition condition);

    /**
     * 功能描述: 查询评论回复列表
     *
     * @Author: chenxin 
     * @Param: [condition]
     * @Date: 2020/10/27
     */
    IPage<CommentReply> queryCommentReplyList(QueryCommentReplyCondition condition);

}
