package com.cx.blog.dto.request.article;

import com.cx.blog.commom.PageParam;

/**
 * <文章列表查询条件>
 *
 * @Author: chenxin
 * @Date: 2020/8/4
 */
public class QueryArticleCondition extends PageParam {

    /**
     * 关键字
     */
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
