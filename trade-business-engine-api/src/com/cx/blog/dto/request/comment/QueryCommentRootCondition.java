package com.cx.blog.dto.request.comment;

import com.cx.blog.commom.PageParam;

/**
 * <查询主评论条件>
 *
 * @Author: chenxin
 * @Date: 2020/10/27
 */
public class QueryCommentRootCondition extends PageParam {

    /**
     * 评论所属对象id
     */
    private Long ownerId;

    /**
     * 评论对象类型
     */
    private Integer ownerType;

    /**
     * 评论人id
     */
    private Long fromUserId;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(Integer ownerType) {
        this.ownerType = ownerType;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }
}
