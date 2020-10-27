package com.cx.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cx.blog.dto.request.article.QueryArticleCondition;
import com.cx.blog.dto.request.article.SaveArticleRequest;
import com.cx.blog.dto.response.ArticleDetail;
import com.cx.blog.entity.article.Article;

public interface IAPIArticleService {

    /**
     * 功能描述: 新增文章
     *
     * @Author: chenxin 
     * @Param: [request]
     * @Date: 2020/10/26
     */
    Long addArticle(SaveArticleRequest request);

    /**
     * 功能描述: 编辑文章
     *
     * @Author: chenxin 
     * @Param: [request]
     * @Date: 2020/10/26
     */
    void updateArticle(SaveArticleRequest request);

    /**
     * 功能描述: 根据id获取文章
  *
     * @Author: chenxin 
     * @Param: [id]
     * @Date: 2020/10/26
     */
    Article getArticleById(Long id);
    
    /**
     * 功能描述: 文章详情
     *
     * @Author: chenxin 
     * @Param: [id]
     * @Date: 2020/10/26
     */
    ArticleDetail queryArticleDetail(Long id);
    

    /**
     * 功能描述: 文章列表查询
     *
     * @Author: chenxin 
     * @Param: [condition]
     * @Date: 2020/10/26
     */
    IPage<Article> pageQueryArticleInfoList(QueryArticleCondition condition);

}
