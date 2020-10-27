package com.cx.blog.service;

import com.cx.blog.entity.log.LogOperation;

public interface IAPILogOperationService {

    /**
     * 功能描述: 添加操作日志
     *
     * @Author: chenxin
     * @Param: [logOperation]
     * @Date: 2020/10/27
     */
    void insertOperationLog(LogOperation logOperation);

}
