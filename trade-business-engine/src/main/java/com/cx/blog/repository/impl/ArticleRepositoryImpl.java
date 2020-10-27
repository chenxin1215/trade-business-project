package com.cx.blog.repository.impl;

import com.cx.blog.entity.article.Article;
import com.cx.blog.repository.ArticleRepository;
import com.cx.blog.service.IAPIArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

    private static final String POST_CACHE_NAME = "business:article";

    @Resource(name = "redisTemplate")
    private HashOperations<String, Long, Article> articleCache;

    @Autowired
    private IAPIArticleService articleService;

    @Override
    public Article get(Long articleId) {

        Article article = articleCache.get(POST_CACHE_NAME, articleId);

        if (article == null) {
            // 初始化
            article = articleService.getArticleById(articleId);
            articleCache.put(POST_CACHE_NAME, articleId, article);
        }

        return article;
    }

    @Override
    public void update(Article article) {
        Long articleId = article.getArticleId();
        articleCache.put(POST_CACHE_NAME, articleId, article);
    }

}
