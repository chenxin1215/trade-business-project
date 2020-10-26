package com.cx.blog.entity.label;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * 标签
 * 
 * @author chenxin
 */
public class Label implements Serializable {

    /**
     * 标签id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 标签名
     */
    private String labelName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取标签id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置标签id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取标签名
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * 设置标签名
     */
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    /**
     * 获取创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}