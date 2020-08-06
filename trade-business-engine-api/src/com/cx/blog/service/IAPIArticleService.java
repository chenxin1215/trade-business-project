package com.cx.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cx.blog.dto.request.QueryArticleCondition;
import com.cx.blog.dto.request.SaveArticleRequest;
import com.cx.blog.dto.response.ArticleDetail;
import com.cx.blog.entity.article.Article;

import java.util.List;

public interface IAPIArticleService {

    Long addArticle(SaveArticleRequest request);

    void updateArticle(SaveArticleRequest request);

    Article getArticleById(Long id);

    ArticleDetail queryArticleDetail(Long id);

    List<Article> queryArticleList(QueryArticleCondition condition);

    IPage<Article> pageQueryArticleInfoList(QueryArticleCondition condition);

}
