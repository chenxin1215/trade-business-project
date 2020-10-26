package com.cx.blog.entity.comment;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论回复
 * 
 * @author chenxin
 */
public class CommentReply implements Serializable {

    /**
     * 评论回复记录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 主评论id
     */
    private Long commentRootId;

    /**
     * 回复人id
     */
    private Long replyUserId;

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

    private String toReplyUserName;

    /**
     * 被回复人邮箱
     */
    private String toReplyUserEmail;

    /**
     * 回复内容
     */
    private String replyContent;

    /**
     * 回复时间
     */
    private Date replyTime;

    /**
     * 评论回复状态 1-正常 2-删除
     */
    private Integer replyState;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取评论回复记录id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置评论回复记录id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取主评论id
     */
    public Long getCommentRootId() {
        return commentRootId;
    }

    /**
     * 设置主评论id
     */
    public void setCommentRootId(Long commentRootId) {
        this.commentRootId = commentRootId;
    }

    /**
     * 获取回复人id
     */
    public Long getReplyUserId() {
        return replyUserId;
    }

    /**
     * 设置回复人id
     */
    public void setReplyUserId(Long replyUserId) {
        this.replyUserId = replyUserId;
    }

    /**
     * 获取回复人名称
     */
    public String getReplyUserName() {
        return replyUserName;
    }

    /**
     * 设置回复人名称
     */
    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
    }

    /**
     * 获取回复人邮箱
     */
    public String getReplyUserEmail() {
        return replyUserEmail;
    }

    /**
     * 设置回复人邮箱
     */
    public void setReplyUserEmail(String replyUserEmail) {
        this.replyUserEmail = replyUserEmail;
    }

    /**
     * 获取被回复的评论回复id
     */
    public Long getToReplyId() {
        return toReplyId;
    }

    /**
     * 设置被回复的评论回复id
     */
    public void setToReplyId(Long toReplyId) {
        this.toReplyId = toReplyId;
    }

    /**
     * 获取被回复人id
     */
    public Long getToReplyUserId() {
        return toReplyUserId;
    }

    /**
     * 设置被回复人id
     */
    public void setToReplyUserId(Long toReplyUserId) {
        this.toReplyUserId = toReplyUserId;
    }

    public String getToReplyUserName() {
        return toReplyUserName;
    }

    public void setToReplyUserName(String toReplyUserName) {
        this.toReplyUserName = toReplyUserName;
    }

    /**
     * 获取被回复人邮箱
     */
    public String getToReplyUserEmail() {
        return toReplyUserEmail;
    }

    /**
     * 设置被回复人邮箱
     */
    public void setToReplyUserEmail(String toReplyUserEmail) {
        this.toReplyUserEmail = toReplyUserEmail;
    }

    /**
     * 获取回复内容
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * 设置回复内容
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    /**
     * 获取回复时间
     */
    public Date getReplyTime() {
        return replyTime;
    }

    /**
     * 设置回复时间
     */
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    /**
     * 获取评论回复状态 1-正常 2-删除
     */
    public Integer getReplyState() {
        return replyState;
    }

    /**
     * 设置评论回复状态 1-正常 2-删除
     */
    public void setReplyState(Integer replyState) {
        this.replyState = replyState;
    }

    /**
     * 获取创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}