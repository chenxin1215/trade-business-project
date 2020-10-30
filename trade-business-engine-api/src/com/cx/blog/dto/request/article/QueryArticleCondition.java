package com.cx.blog.dto.request.article;

import com.cx.blog.commom.PageParam;

import java.util.List;

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

    /**
     * 排序类型 1-推荐(置顶) 2-发布时间 3-热评
     */
    private Integer sortType;

    /**
     * 标签
     */
    private List<Long> labelIdList;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getSortType() {
        return sortType;
    }

    public void setSortType(Integer sortType) {
        this.sortType = sortType;
    }

    public List<Long> getLabelIdList() {
        return labelIdList;
    }

    public void setLabelIdList(List<Long> labelIdList) {
        this.labelIdList = labelIdList;
    }
}
