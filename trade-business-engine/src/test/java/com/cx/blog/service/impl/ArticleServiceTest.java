package com.cx.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cx.blog.TradeBusinessEngineApplication;
import com.cx.blog.dto.request.article.QueryArticleCondition;
import com.cx.blog.dto.response.ArticleDetail;
import com.cx.blog.entity.article.Article;
import com.cx.utils.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cx.blog.dto.request.article.SaveArticleRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {

    private static Logger LOGGER = LoggerFactory.getLogger(ArticleServiceTest.class);

    @Autowired
    private IAPIArticleService articleService;

    @Test
    public void addArticle() {
        SaveArticleRequest request = new SaveArticleRequest();
        request.setArticleTitle("陈新测试标题！！");
        request.setArticleContent("阿三打撒打撒打撒打撒阿德");
        Long id = articleService.addArticle(request);
        LOGGER.info("id:{}", id);
    }

    @Test
    public void updateArticle() {

    }

    @Test
    public void getArticleById() {

    }

    @Test
    public void queryArticleDetail() {
        ArticleDetail articleDetail = articleService.queryArticleDetail(1L);

        LOGGER.info("articleDetail:{}", JsonUtil.toString(articleDetail));
    }

    @Test
    public void pageQueryArticleInfoList() {

        QueryArticleCondition queryArticleCondition = new QueryArticleCondition();
        queryArticleCondition.setKeyword("测试");
        IPage<Article> articleIPage = articleService.pageQueryArticleInfoList(queryArticleCondition);

        LOGGER.info("articleIPage:{}", JsonUtil.toString(articleIPage));

    }
}