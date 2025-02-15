package com.cx.blog.entity.article;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章
 * 
 * @author chenxin
 */
public class Article implements Serializable {

    /**
     * 文章id
     */
    @TableId(value = "article_id", type = IdType.AUTO)
    private Long articleId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 标题图片
     */
    private String articleTitleImage;

    /**
     * 文章类型
     */
    private Long articleType;

    /**
     * 阅读量
     */
    private Integer readCount;

    /**
     * 文章状态(1:正常；2：删除)
     */
    private Integer state;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 文章内容
     */
    private String articleContent;

    private static final long serialVersionUID = 1L;

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
     * 获取文章标题
     */
    public String getArticleTitle() {
        return articleTitle;
    }

    /**
     * 设置文章标题
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * 获取标题图片
     */
    public String getArticleTitleImage() {
        return articleTitleImage;
    }

    /**
     * 设置标题图片
     */
    public void setArticleTitleImage(String articleTitleImage) {
        this.articleTitleImage = articleTitleImage;
    }

    /**
     * 获取文章类型
     */
    public Long getArticleType() {
        return articleType;
    }

    /**
     * 设置文章类型
     */
    public void setArticleType(Long articleType) {
        this.articleType = articleType;
    }

    /**
     * 获取阅读量
     */
    public Integer getReadCount() {
        return readCount;
    }

    /**
     * 设置阅读量
     */
    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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

    /**
     * 获取文章内容
     */
    public String getArticleContent() {
        return articleContent;
    }

    /**
     * 设置文章内容
     */
    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }
}