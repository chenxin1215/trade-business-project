package com.cx.blog.dto.request.label;

import com.cx.blog.commom.PageParam;

/**
 * 〈查询标签条件〉
 *
 * @author chenxin
 * @date 2020/10/26
 */
public class QueryLabelCondition extends PageParam {

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