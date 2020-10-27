package com.cx.blog.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.cx.blog.dao.log.LogOperationMapper;
import com.cx.blog.entity.log.LogOperation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <操作日志接口>
 *
 * @Author: chenxin
 * @Date: 2020/10/27
 */
@Service
public class LogOperationService implements IAPILogOperationService {

    @Autowired
    private LogOperationMapper logOperationMapper;

    @Override
    public void insertOperationLog(LogOperation logOperation) {
        logOperationMapper.insert(logOperation);
    }
}
