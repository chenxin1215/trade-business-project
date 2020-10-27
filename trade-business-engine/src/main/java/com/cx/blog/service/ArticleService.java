package com.cx.blog.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.blog.dao.article.ArticleMapper;
import com.cx.blog.dto.request.article.QueryArticleCondition;
import com.cx.blog.dto.request.article.SaveArticleRequest;
import com.cx.blog.dto.request.label.SaveRelLabelRequest;
import com.cx.blog.dto.response.ArticleDetail;
import com.cx.blog.entity.article.Article;
import com.cx.blog.enums.BaseStateEnum;
import com.cx.blog.enums.ContentTypeEnum;
import com.cx.utils.exception.BizRtException;
import com.cx.utils.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 *
 * @Author: chenxin
 * @Date: 2020/8/4
 */
@Service
public class ArticleService implements IAPIArticleService {

    // 默认文章排序
    private static final Integer DEFAULT_SORT = 100;

    // 文章标题最大长度
    private static final Integer ARTICLE_TITLE_MAX_LEN = 50;

    private static Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private IAPILabelService labelService;

    @Override
    @Transactional
    public Long addArticle(SaveArticleRequest request) {
        LOGGER.info("### addArticle start");

        // 检查入参
        checkSaveArticleRequest(request);

        // 新增文章
        Article addArticle = new Article();
        BeanUtils.copyProperties(request, addArticle);
        addArticle.setState(BaseStateEnum.ENABLE.value());
        addArticle.setSort(DEFAULT_SORT);
        articleMapper.insert(addArticle);
        Long articleId = addArticle.getArticleId();

        // 添加关联标签
        SaveRelLabelRequest relLabelRequest = new SaveRelLabelRequest();
        relLabelRequest.setRelId(articleId);
        relLabelRequest.setRelType(ContentTypeEnum.ARTICLE.value());
        relLabelRequest.setLabelIdList(relLabelRequest.getLabelIdList());
        labelService.saveRelLabel(relLabelRequest);

        LOGGER.info("### addArticle end");
        return articleId;
    }

    private void checkSaveArticleRequest(SaveArticleRequest request) {
        String articleTitle = request.getArticleTitle();
        String articleContent = request.getArticleContent();
        Assert.notNull(articleTitle, "文章标题不能为空");
        Assert.notNull(articleContent, "文章内容不能为空");
        if (articleTitle.length() > ARTICLE_TITLE_MAX_LEN) {
            LOGGER.error("标题字符长度过长！len:{}", articleTitle.length());
            throw new BizRtException("文章标题长度过长！ 当前：" + articleTitle.length());
        }
        if (StringUtils.isSpecialChar(articleTitle)) {
            LOGGER.error("标题不能含有特殊字符！articleTitle:{}", articleTitle);
            throw new BizRtException("文章标题不能含有特殊字符");
        }
    }

    @Override
    public void updateArticle(SaveArticleRequest request) {
        LOGGER.info("### updateArticle start");
        // 检查入参
        Long articleId = request.getArticleId();
        checkSaveArticleRequest(request);

        Article article = getArticleById(articleId);
        if (article == null) {
            LOGGER.error("### 文章不存在系统！ articleId:{}", articleId);
            throw new BizRtException("操作失败！文章不存在本系统!");
        }

        Article addArticle = new Article();
        BeanUtils.copyProperties(request, addArticle);
        articleMapper.updateById(addArticle);

        // 更新关联标签
        SaveRelLabelRequest relLabelRequest = new SaveRelLabelRequest();
        relLabelRequest.setRelId(articleId);
        relLabelRequest.setRelType(ContentTypeEnum.ARTICLE.value());
        relLabelRequest.setLabelIdList(request.getLabelIdList());
        labelService.saveRelLabel(relLabelRequest);

        LOGGER.info("### updateArticle end");
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

        // 浏览数+1
        article.setReadCount(article.getReadCount() + 1);
        articleMapper.updateById(article);

        return articleDetail;
    }

    @Override
    public IPage<Article> pageQueryArticleInfoList(QueryArticleCondition condition) {
        IPage<Article> page = new Page<>(condition.getPage(), condition.getPageSize());

        LambdaQueryWrapper<Article> queryWrapper = getArticleLambdaQueryWrapper(condition);

        IPage<Article> articleIPage = articleMapper.selectPage(page, queryWrapper);
        articleIPage.setTotal(page.getTotal());

        return articleIPage;
    }

    private LambdaQueryWrapper<Article> getArticleLambdaQueryWrapper(QueryArticleCondition condition) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(condition.getKeyword())) {
            queryWrapper.like(Article::getArticleTitle, "%" + condition.getKeyword() + "%");
        }
        return queryWrapper;
    }

}
