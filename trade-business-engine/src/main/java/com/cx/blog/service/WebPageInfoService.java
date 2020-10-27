package com.cx.blog.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.cx.blog.dao.pageinfo.WebPageInfoMapper;
import com.cx.blog.entity.pageinfo.WebPageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <页面配置接口>
 *
 * @Author: chenxin
 * @Date: 2020/10/27
 */
@Service
public class WebPageInfoService implements IAPIWebPageInfoService {

    @Autowired
    private WebPageInfoMapper webPageInfoMapper;

    @Override
    public Long add(WebPageInfo webPageInfo) {

        webPageInfoMapper.insert(webPageInfo);

        return webPageInfo.getId();
    }

    @Override
    public void update(WebPageInfo webPageInfo) {
        webPageInfoMapper.updateById(webPageInfo);
    }

    @Override
    public WebPageInfo getById(Long id) {
        return webPageInfoMapper.selectById(id);
    }

    @Override
    public List<WebPageInfo> queryAll() {
        return webPageInfoMapper.selectList(null);
    }
}
