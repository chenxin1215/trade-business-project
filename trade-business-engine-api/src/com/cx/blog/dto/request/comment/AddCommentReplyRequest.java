package com.cx.blog.dto.request.comment;

import java.io.Serializable;

/**
 * <新增评论回复入参>
 *
 * @Author: chenxin
 * @Date: 2020/10/27
 */
public class AddCommentReplyRequest implements Serializable {

    /**
     * 主评论id
     */
    private Long commentRootId;

    /**
     * 回复人id
     */
    private Long replyUserId;

    /**
     * 回复者头像
     */
    private String replyUserHeadImg;

    /**
     * 回复人名称
     */
    private String replyUserName;

    /**
     * 回复人邮箱
     */
    private String replyUserEmail;

    /**
     * 被回复的评论回复id
     */
    private Long toReplyId;

    /**
     * 被回复人id
     */
    private Long toReplyUserId;

    /**
     * 被回复人名称
     */
    private String toReplyUserName;

    /**
     * 被回复人邮箱
     */
    private String toReplyUserEmail;

    /**
     * 回复内容
     */
    private String replyContent;

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

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
    }

    public String getReplyUserEmail() {
        return replyUserEmail;
    }

    public void setReplyUserEmail(String replyUserEmail) {
        this.replyUserEmail = replyUserEmail;
    }

    public Long getToReplyId() {
        return toReplyId;
    }

    public void setToReplyId(Long toReplyId) {
        this.toReplyId = toReplyId;
    }

    public Long getToReplyUserId() {
        return toReplyUserId;
    }

    public void setToReplyUserId(Long toReplyUserId) {
        this.toReplyUserId = toReplyUserId;
    }

    public String getToReplyUserName() {
        return toReplyUserName;
    }

    public void setToReplyUserName(String toReplyUserName) {
        this.toReplyUserName = toReplyUserName;
    }

    public String getToReplyUserEmail() {
        return toReplyUserEmail;
    }

    public void setToReplyUserEmail(String toReplyUserEmail) {
        this.toReplyUserEmail = toReplyUserEmail;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyUserHeadImg() {
        return replyUserHeadImg;
    }

    public void setReplyUserHeadImg(String replyUserHeadImg) {
        this.replyUserHeadImg = replyUserHeadImg;
    }
}
