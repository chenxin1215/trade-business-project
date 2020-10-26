package com.cx.blog.dto.request;

import java.io.Serializable;
import java.util.List;

/**
 * 保存文章入参
 * 
 * @Author: chenxin
 * @Date: 2020/8/4
 */
public class SaveArticleRequest implements Serializable {

    /**
     * 文章id
     */
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
     * 文章状态(1:正常；0：屏蔽)
     */
    private Boolean articleStatus;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 关联标签ids
     */
    private List<Long> labelIdList;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleTitleImage() {
        return articleTitleImage;
    }

    public void setArticleTitleImage(String articleTitleImage) {
        this.articleTitleImage = articleTitleImage;
    }

    public Long getArticleType() {
        return articleType;
    }

    public void setArticleType(Long articleType) {
        this.articleType = articleType;
    }

    public Boolean getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Boolean articleStatus) {
        this.articleStatus = articleStatus;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public List<Long> getLabelIdList() {
        return labelIdList;
    }

    public void setLabelIdList(List<Long> labelIdList) {
        this.labelIdList = labelIdList;
    }
}
