package com.cx.blog.dto.request.comment;

import com.cx.blog.commom.PageParam;

/**
 * <查询评论回复条件>
 *
 * @Author: chenxin
 * @Date: 2020/10/27
 */
public class QueryCommentReplyCondition extends PageParam {

    /**
     * 主评论id
     */
    private Long commentRootId;

    /**
     * 回复人id
     */
    private Long replyUserId;

    public Long getCommentRootId() {
        return commentRootId;
    }

    public void setCommentRootId(Long commentRootId) {
        this.commentRootId = commentRootId;
    }

    public Long getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Long replyUserId) {
        this.replyUserId = replyUserId;
    }
}
