package com.cx.blog.dao.label;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cx.blog.dto.request.label.QueryLabelCondition;
import com.cx.blog.dto.response.LabelInfo;
import com.cx.blog.entity.label.Label;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * LabelMapper继承基类
 */
public interface LabelMapper extends BaseMapper<Label> {

    List<LabelInfo> queryLabelList(IPage<Label> page, @Param("condition") QueryLabelCondition condition);

}