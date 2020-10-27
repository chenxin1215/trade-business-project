package com.cx.blog.repository;

import com.cx.blog.entity.article.Article;

public interface ArticleRepository {

    /**
     * 功能描述: 从缓存中获取文章
     *
     * @Author: chenxin 
     * @Param: [articleId]
     * @Date: 2020/10/27
     */
    Article get(Long articleId);

    /**
     * 功能描述: 维护缓存中的文章
     *
     * @Author: chenxin 
     * @Param: [articleId]
     * @Date: 2020/10/27
     */
    void update(Article article);

}
