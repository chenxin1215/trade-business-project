package com.cx.blog.entity.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * log_operation
 * @author 
 */
public class LogOperation implements Serializable {
    /**
     * 操作日志表自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long operationUserId;

    /**
     * 操作人
     */
    private String operationUserName;

    /**
     * 操作时间
     */
    private Date operatingTime;

    /**
     * 操作类型
     */
    private Integer operatorType;

    /**
     * 操作内容
     */
    private String operationContent;

    /**
     * 操作人 网络ip
     */
    private String userIpAddress;

    /**
     * 操作人本地ip
     */
    private String userLocalIp;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取操作日志表自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置操作日志表自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Long getOperationUserId() {
        return operationUserId;
    }

    public void setOperationUserId(Long operationUserId) {
        this.operationUserId = operationUserId;
    }

    /**
     * 获取操作人
     */
    public String getOperationUserName() {
        return operationUserName;
    }

    /**
     * 设置操作人
     */
    public void setOperationUserName(String operationUserName) {
        this.operationUserName = operationUserName;
    }

    /**
     * 获取操作时间
     */
    public Date getOperatingTime() {
        return operatingTime;
    }

    /**
     * 设置操作时间
     */
    public void setOperatingTime(Date operatingTime) {
        this.operatingTime = operatingTime;
    }

    /**
     * 获取操作类型
     */
    public Integer getOperatorType() {
        return operatorType;
    }

    /**
     * 设置操作类型
     */
    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    /**
     * 获取操作内容
     */
    public String getOperationContent() {
        return operationContent;
    }

    /**
     * 设置操作内容
     */
    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent;
    }

    /**
     * 获取操作人 网络ip
     */
    public String getUserIpAddress() {
        return userIpAddress;
    }

    /**
     * 设置操作人 网络ip
     */
    public void setUserIpAddress(String userIpAddress) {
        this.userIpAddress = userIpAddress;
    }

    /**
     * 获取操作人本地ip
     */
    public String getUserLocalIp() {
        return userLocalIp;
    }

    /**
     * 设置操作人本地ip
     */
    public void setUserLocalIp(String userLocalIp) {
        this.userLocalIp = userLocalIp;
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
     * 获取更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}