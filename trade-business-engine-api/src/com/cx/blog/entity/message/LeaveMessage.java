package com.cx.blog.entity.message;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * 留言表
 * 
 * @author chenxin
 */
public class LeaveMessage implements Serializable {
    /**
     * 留言表自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父级Id
     */
    private Long parentId;

    /**
     * 留言人昵称
     */
    private String userNickName;

    /**
     * 留言状态（1：启用，0：停用）
     */
    private Boolean status;

    /**
     * 留言时间
     */
    private Date leaveTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 留言内容
     */
    private String content;

    private static final long serialVersionUID = 1L;

    /**
     * 获取留言表自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置留言表自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取父级Id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父级Id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取留言人昵称
     */
    public String getUserNickName() {
        return userNickName;
    }

    /**
     * 设置留言人昵称
     */
    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    /**
     * 获取留言状态（1：启用，0：停用）
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置留言状态（1：启用，0：停用）
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取留言时间
     */
    public Date getLeaveTime() {
        return leaveTime;
    }

    /**
     * 设置留言时间
     */
    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
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

    /**
     * 获取留言内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置留言内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}