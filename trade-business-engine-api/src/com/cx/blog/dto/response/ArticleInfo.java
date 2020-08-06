package com.cx.blog.dto.response;

import com.cx.blog.entity.article.Article;

/**
 * <>
 *
 * @Author: chenxin
 * @Date: 2020/8/4
 */
public class ArticleInfo extends Article {

    private String articleTitleImgUrl;

    public String getArticleTitleImgUrl() {
        return articleTitleImgUrl;
    }

    public void setArticleTitleImgUrl(String articleTitleImgUrl) {
        this.articleTitleImgUrl = articleTitleImgUrl;
    }
}
