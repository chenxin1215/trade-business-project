package com.cx.blog.dto.request.comment;

import java.io.Serializable;

/**
 * <新增主评论入参>
 *
 * @Author: chenxin
 * @Date: 2020/10/27
 */
public class AddCommentRootRequest implements Serializable {

    /**
     * 被评论对象id
     */
    private Long ownerId;

    /**
     * 被评论对象类型
     */
    private Integer ownerType;

    /**
     * 评论者id
     */
    private Long formUserId;

    /**
     * 评论者头像
     */
    private String fromUserHeadImg;

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

    public Long getFormUserId() {
        return formUserId;
    }

    public void setFormUserId(Long formUserId) {
        this.formUserId = formUserId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(Integer ownerType) {
        this.ownerType = ownerType;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getFromUserEmail() {
        return fromUserEmail;
    }

    public void setFromUserEmail(String fromUserEmail) {
        this.fromUserEmail = fromUserEmail;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getFromUserHeadImg() {
        return fromUserHeadImg;
    }

    public void setFromUserHeadImg(String fromUserHeadImg) {
        this.fromUserHeadImg = fromUserHeadImg;
    }
}
