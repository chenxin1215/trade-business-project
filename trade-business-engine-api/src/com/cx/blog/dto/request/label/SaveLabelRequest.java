package com.cx.blog.dto.request.label;

import java.io.Serializable;

/**
 * 〈保存标签入参〉
 *
 * @author chenxin
 * @date 2020/10/26
 */
public class SaveLabelRequest implements Serializable {

    /**
     * 标签id
     */
    private Long labelId;

    /**
     * 标签名
     */
    private String labelName;

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
}