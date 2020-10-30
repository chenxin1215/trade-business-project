package com.cx.blog.entity.comment;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * 主评论
 * 
 * @author chenxin
 */
public class CommentRoot implements Serializable {

    /**
     * 评论id
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;

    /**
     * 被评论对象id
     */
    private Long ownerId;

    /**
     * 被评论对象类型 1-本系统 2-文章
     */
    private Integer ownerType;

    /**
     * 评论者名称
     */
    private String fromUserName;

    /**
     * 评论者邮箱
     */
    private String fromUserEmail;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论状态(1:正常；2：删除)
     */
    private Integer state;

    /**
     * 评论时间
     */
    private Date commentTime;

    /**
     * 是否置顶 0-否 1-是
     */
    private Boolean isTop;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取评论id
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * 设置评论id
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取被评论对象id
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * 设置被评论对象id
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * 获取被评论对象类型 1-本系统 2-文章
     */
    public Integer getOwnerType() {
        return ownerType;
    }

    /**
     * 设置被评论对象类型 1-本系统 2-文章
     */
    public void setOwnerType(Integer ownerType) {
        this.ownerType = ownerType;
    }

    /**
     * 获取评论者名称
     */
    public String getFromUserName() {
        return fromUserName;
    }

    /**
     * 设置评论者名称
     */
    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    /**
     * 获取评论者邮箱
     */
    public String getFromUserEmail() {
        return fromUserEmail;
    }

    /**
     * 设置评论者邮箱
     */
    public void setFromUserEmail(String fromUserEmail) {
        this.fromUserEmail = fromUserEmail;
    }

    /**
     * 获取评论内容
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * 设置评论内容
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取评论时间
     */
    public Date getCommentTime() {
        return commentTime;
    }

    /**
     * 设置评论时间
     */
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Boolean getTop() {
        return isTop;
    }

    public void setTop(Boolean top) {
        isTop = top;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}