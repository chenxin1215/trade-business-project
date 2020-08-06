package com.cx.blog.entity.article;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * rel_article_label
 * 
 * @author
 */
public class RelArticleLabel implements Serializable {
    /**
     * 文章与文章标签关系表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 文章标签表id
     */
    private Long articleLabelId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取文章id
     */
    public Long getArticleId() {
        return articleId;
    }

    /**
     * 设置文章id
     */
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取文章标签表id
     */
    public Long getArticleLabelId() {
        return articleLabelId;
    }

    /**
     * 设置文章标签表id
     */
    public void setArticleLabelId(Long articleLabelId) {
        this.articleLabelId = articleLabelId;
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
     * 获取修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}