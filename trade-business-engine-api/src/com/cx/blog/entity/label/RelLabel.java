package com.cx.blog.entity.label;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * 标签关系实体
 * 
 * @author chenxin
 */
public class RelLabel implements Serializable {

    /**
     * 文章与文章标签关系表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 管理对象id
     */
    private Long relId;

    /**
     * 管理对象类型
     */
    private Integer relType;

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
     * 获取文章与文章标签关系表id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置文章与文章标签关系表id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取管理对象id
     */
    public Long getRelId() {
        return relId;
    }

    /**
     * 设置管理对象id
     */
    public void setRelId(Long relId) {
        this.relId = relId;
    }

    /**
     * 获取管理对象类型
     */
    public Integer getRelType() {
        return relType;
    }

    /**
     * 设置管理对象类型
     */
    public void setRelType(Integer relType) {
        this.relType = relType;
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