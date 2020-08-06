package com.cx.blog.dto.request;

import com.cx.blog.commom.PageParam;

/**
 * <>
 *
 * @Author: chenxin
 * @Date: 2020/8/4
 */
public class QueryArticleCondition extends PageParam {

    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
