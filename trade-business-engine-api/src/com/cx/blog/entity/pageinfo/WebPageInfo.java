package com.cx.blog.entity.pageinfo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * web_page_info
 * 
 * @author
 */
public class WebPageInfo implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 座右铭
     */
    private String motto;

    /**
     * 首页中间内容
     */
    private String indexInfo;

    /**
     * 底部座右铭
     */
    private String bottomMotto;

    /**
     * 个人信息
     */
    private String personInfo;

    /**
     * 个人技能
     */
    private String personSkills;

    /**
     * QQ
     */
    private String qq;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

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
     * 获取主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取座右铭
     */
    public String getMotto() {
        return motto;
    }

    /**
     * 设置座右铭
     */
    public void setMotto(String motto) {
        this.motto = motto;
    }

    /**
     * 获取首页中间内容
     */
    public String getIndexInfo() {
        return indexInfo;
    }

    /**
     * 设置首页中间内容
     */
    public void setIndexInfo(String indexInfo) {
        this.indexInfo = indexInfo;
    }

    /**
     * 获取底部座右铭
     */
    public String getBottomMotto() {
        return bottomMotto;
    }

    /**
     * 设置底部座右铭
     */
    public void setBottomMotto(String bottomMotto) {
        this.bottomMotto = bottomMotto;
    }

    /**
     * 获取个人信息
     */
    public String getPersonInfo() {
        return personInfo;
    }

    /**
     * 设置个人信息
     */
    public void setPersonInfo(String personInfo) {
        this.personInfo = personInfo;
    }

    /**
     * 获取个人技能
     */
    public String getPersonSkills() {
        return personSkills;
    }

    /**
     * 设置个人技能
     */
    public void setPersonSkills(String personSkills) {
        this.personSkills = personSkills;
    }

    /**
     * 获取QQ
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置QQ
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     */
    public void setAddress(String address) {
        this.address = address;
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