package com.cx.blog.dto.response;

import com.cx.blog.entity.article.Article;

/**
 * <>
 *
 * @Author: chenxin
 * @Date: 2020/8/4
 */
public class ArticleDetail extends Article {

    private String articleTitleImgUrl;

    /**
     * 评论数
     */
    private Integer commentNum;

    public String getArticleTitleImgUrl() {
        return articleTitleImgUrl;
    }

    public void setArticleTitleImgUrl(String articleTitleImgUrl) {
        this.articleTitleImgUrl = articleTitleImgUrl;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }
}
