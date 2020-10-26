package com.cx.blog.dto.request.label;

import java.io.Serializable;
import java.util.List;

/**
 * 〈保存标签关联关系入参〉
 *
 * @author chenxin
 * @date 2020/10/26
 */
public class SaveRelLabelRequest implements Serializable {

    /**
     * 标签idList
     */
    private List<Long> labelIdList;

    /**
     * 关联者id
     */
    private Long relId;

    /**
     * 关联者类型
     * 
     * @see com.cx.blog.enums.ContentTypeEnum
     */
    private Integer relType;

    public List<Long> getLabelIdList() {
        return labelIdList;
    }

    public void setLabelIdList(List<Long> labelIdList) {
        this.labelIdList = labelIdList;
    }

    public Long getRelId() {
        return relId;
    }

    public void setRelId(Long relId) {
        this.relId = relId;
    }

    public Integer getRelType() {
        return relType;
    }

    public void setRelType(Integer relType) {
        this.relType = relType;
    }
}