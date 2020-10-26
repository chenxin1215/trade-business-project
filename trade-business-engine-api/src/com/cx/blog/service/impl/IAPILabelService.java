package com.cx.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cx.blog.dto.request.label.QueryLabelCondition;
import com.cx.blog.dto.request.label.SaveLabelRequest;
import com.cx.blog.dto.request.label.SaveRelLabelRequest;
import com.cx.blog.entity.label.Label;

/**
 * 〈标签接口〉
 *
 * @author chenxin
 * @date 2020/10/26
 */
public interface IAPILabelService {

    /**
     * @Description: 新增标签
     *
     * @Author: chenxin
     * @Date: 2020/10/26
     */
    Long addLabel(SaveLabelRequest request);

    /**
     * @Description: 编辑标签
     *
     * @Author: chenxin
     * @Date: 2020/10/26
     */
    void updateLabel(SaveLabelRequest request);

    /**
     * @Description: 根据id查询
     *
     * @Author: chenxin
     * @Date: 2020/10/26
     */
    Label getLabelById(Long labelId);

    /**
     * @Description: 标签列表
     *
     * @Author: chenxin
     * @Date: 2020/10/26
     */
    IPage<Label> queryLabelList(QueryLabelCondition condition);

    /**
     * @Description: 更新标签关联关系
     *
     * @Author: chenxin
     * @Date: 2020/10/26
     */
    void saveRelLabel(SaveRelLabelRequest relLabelRequest);

}
