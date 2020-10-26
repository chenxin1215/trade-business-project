package com.cx.blog.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.blog.dao.label.LabelMapper;
import com.cx.blog.dao.label.RelLabelMapper;
import com.cx.blog.dto.request.label.QueryLabelCondition;
import com.cx.blog.dto.request.label.SaveLabelRequest;
import com.cx.blog.dto.request.label.SaveRelLabelRequest;
import com.cx.blog.entity.label.Label;
import com.cx.blog.entity.label.RelLabel;
import com.cx.utils.exception.BizRtException;
import com.cx.utils.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 〈〉
 *
 * @author chenxin
 * @date 2020/10/26
 */
@Service
public class LabelService implements IAPILabelService {

    private static Logger LOGGER = LoggerFactory.getLogger(LabelService.class);

    @Autowired
    private LabelMapper labelMapper;

    @Autowired
    private RelLabelMapper relLabelMapper;

    @Override
    public Long addLabel(SaveLabelRequest request) {
        Assert.notNull(request.getLabelName(), "标签名不能为空！");

        Label label = new Label();
        label.setLabelName(request.getLabelName());
        labelMapper.insert(label);

        return label.getId();
    }

    @Override
    public void updateLabel(SaveLabelRequest request) {
        Long labelId = request.getLabelId();
        String labelName = request.getLabelName();
        Assert.notNull(labelName, "标签名不能为空！");

        Label oldLabel = labelMapper.selectOne(new LambdaQueryWrapper<Label>().eq(Label::getLabelName, labelName));
        if (oldLabel != null && oldLabel.getId() != labelId) {
            LOGGER.error("标签名：{} 已存在， id：{}", labelName, oldLabel.getId());
            throw new BizRtException("标签名已存在");
        }

        Label updateLabel = new Label();
        updateLabel.setId(labelId);
        updateLabel.setLabelName(labelName);
        labelMapper.updateById(updateLabel);
    }

    @Override
    public Label getLabelById(Long labelId) {
        return labelMapper.selectById(labelId);
    }

    @Override
    public IPage<Label> queryLabelList(QueryLabelCondition condition) {
        IPage<Label> page = new Page<>(condition.getPage(), condition.getPageSize());

        LambdaQueryWrapper<Label> labelLambdaQueryWrapper = getLabelLambdaQueryWrapper(condition);

        return labelMapper.selectPage(page, labelLambdaQueryWrapper);
    }

    @Override
    @Transactional
    public void saveRelLabel(SaveRelLabelRequest relLabelRequest) {
        LOGGER.info("### saveRelLabel start ");
        List<Long> labelIdList = relLabelRequest.getLabelIdList();
        if (CollectionUtils.isEmpty(labelIdList)) {
            return;
        }

        Long relId = relLabelRequest.getRelId();
        Integer relType = relLabelRequest.getRelType();
        for (Long labelId : labelIdList) {
            Label label = labelMapper.selectById(labelId);
            if (label == null) {
                LOGGER.error("标签id：{} 在系统不存在！", labelId);
                throw new BizRtException("新增文章失败！关联的标签在系统不存在");
            }
            RelLabel relLabel = new RelLabel();
            relLabel.setLabelId(labelId);
            relLabel.setRelId(relId);
            relLabel.setRelType(relType);
            relLabelMapper.insert(relLabel);
        }
        LOGGER.info("### saveRelLabel end ");
    }

    private LambdaQueryWrapper<Label> getLabelLambdaQueryWrapper(QueryLabelCondition condition) {
        LambdaQueryWrapper<Label> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(condition.getKeyword())) {
            queryWrapper.like(Label::getLabelName, "%" + condition.getKeyword() + "%");
        }
        return queryWrapper;
    }

}