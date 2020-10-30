package com.cx.blog.service;

import com.cx.blog.entity.pageinfo.WebPageInfo;

import java.util.List;

public interface IAPIWebPageInfoService {

    /**
     * 功能描述: 新增页面配置
     *
     * @Author: chenxin
     * @Param: [webPageInfo]
     * @Date: 2020/10/27
     */
    Long add(WebPageInfo webPageInfo);

    /**
     * 功能描述: 修改页面配置
     *
     * @Author: chenxin
     * @Param: [webPageInfo]
     * @Date: 2020/10/27
     */
    void update(WebPageInfo webPageInfo);

    /**
     * 功能描述: 获取页面配置
     *
     * @Author: chenxin
     * @Param: [id]
     * @Date: 2020/10/27
     */
    WebPageInfo getById(Long id);

    /**
     * 功能描述: 获取当前启用的页面配置
     *
     * @Author: chenxin
     * @Param: [id]
     * @Date: 2020/10/27
     */
    WebPageInfo getEnablePageInfo();


    /**
     * 功能描述: 获取所有页面配置
     *
     * @Author: chenxin
     * @Date: 2020/10/27
     */
    List<WebPageInfo> queryAll();

}
