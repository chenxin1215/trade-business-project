package com.cx.blog.dao.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cx.blog.dto.request.article.QueryArticleCondition;
import com.cx.blog.entity.article.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ArticleMapper继承基类
 */
public interface ArticleMapper extends BaseMapper<Article> {


    List<Article> queryListByIds(@Param("idList") List<Long> idList);

    /**
     * @Description: 条件查询文章id
     *
     * @Author: chenxin
     * @Param: [page, condition]
     * @Date: 2020/10/30
     */
    List<Long> pageQueryArticleIdList(IPage<Article> page, @Param("condition") QueryArticleCondition condition);

}