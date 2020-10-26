package com.cx.blog.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.blog.dao.article.ArticleMapper;
import com.cx.blog.dto.request.QueryArticleCondition;
import com.cx.blog.dto.request.SaveArticleRequest;
import com.cx.blog.dto.response.ArticleDetail;
import com.cx.blog.entity.article.Article;
import com.cx.utils.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * <>
 *
 * @Author: chenxin
 * @Date: 2020/8/4
 */
@Service
public class ArticleService implements IAPIArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Long addArticle(SaveArticleRequest request) {
        // TODO 检查入参

        String articleTitle = request.getArticleTitle();
        String articleContent = request.getArticleContent();
        Assert.notNull(articleTitle, "文章标题不能为空");
        Assert.notNull(articleContent, "文章内容不能为空");

        if (articleTitle.length() > 50) {
            // throw new 字符长度过长
        }
        if (StringUtils.isSpecialChar(articleTitle)) {
            // throw new 标题不能含有特殊字符
        }

        Article addArticle = new Article();
        BeanUtils.copyProperties(request, addArticle);
        articleMapper.insert(addArticle);

        return addArticle.getArticleId();
    }

    @Override
    public void updateArticle(SaveArticleRequest request) {
        // TODO 检查入参
        Long articleId = request.getArticleId();

        Article article = getArticleById(articleId);
        if (article == null) {
            // throw new Exception("文章不存在系统");
        }
        Article addArticle = new Article();
        BeanUtils.copyProperties(request, addArticle);
        articleMapper.updateById(addArticle);

    }

    @Override
    public Article getArticleById(Long id) {
        return articleMapper.selectById(id);
    }

    @Override
    public ArticleDetail queryArticleDetail(Long id) {
        Article article = getArticleById(id);
        if (article == null) {
            return null;
        }

        ArticleDetail articleDetail = new ArticleDetail();
        BeanUtils.copyProperties(article, articleDetail);

        // TODO

        return articleDetail;
    }

    @Override
    public IPage<Article> pageQueryArticleInfoList(QueryArticleCondition condition) {
        IPage<Article> page = new Page<>(condition.getPage(), condition.getPageSize());

        LambdaQueryWrapper<Article> queryWrapper = getArticleLambdaQueryWrapper(condition);

        IPage<Article> articleIPage = articleMapper.selectPage(page, queryWrapper);

        return articleIPage;
    }

    private LambdaQueryWrapper<Article> getArticleLambdaQueryWrapper(QueryArticleCondition condition) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Article::getArticleTitle, "%" + condition.getKeyword() + "%");
        return queryWrapper;
    }

}
