package com.cx.blog.entity.article;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * article_comment
 * @author 
 */
public class ArticleComment implements Serializable {
    /**
     * 评论id
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;

    /**
     * 评论文章id
     */
    private Long articleId;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 评论用户id
     */
    private Long commentUserId;

    /**
     * 评论用户名称
     */
    private String commentUserName;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论状态(1:正常；0：屏蔽)
     */
    private Boolean commentStatus;

    /**
     * 评论时间
     */
    private Date commentTime;

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
     * 获取评论文章id
     */
    public Long getArticleId() {
        return articleId;
    }

    /**
     * 设置评论文章id
     */
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取父级id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父级id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取评论用户id
     */
    public Long getCommentUserId() {
        return commentUserId;
    }

    /**
     * 设置评论用户id
     */
    public void setCommentUserId(Long commentUserId) {
        this.commentUserId = commentUserId;
    }

    /**
     * 获取评论用户名称
     */
    public String getCommentUserName() {
        return commentUserName;
    }

    /**
     * 设置评论用户名称
     */
    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
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

    /**
     * 获取评论状态(1:正常；0：屏蔽)
     */
    public Boolean getCommentStatus() {
        return commentStatus;
    }

    /**
     * 设置评论状态(1:正常；0：屏蔽)
     */
    public void setCommentStatus(Boolean commentStatus) {
        this.commentStatus = commentStatus;
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