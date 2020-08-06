package com.cx.blog.entity.article;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * article_label
 * @author 
 */
public class ArticleLabel implements Serializable {
    /**
     * 关系自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文章标签
     */
    private String articleLabel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取关系自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置关系自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取文章标签
     */
    public String getArticleLabel() {
        return articleLabel;
    }

    /**
     * 设置文章标签
     */
    public void setArticleLabel(String articleLabel) {
        this.articleLabel = articleLabel;
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