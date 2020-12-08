package com.cx.blog.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.blog.commom.Constants;
import com.cx.blog.dao.label.LabelMapper;
import com.cx.blog.dao.label.RelLabelMapper;
import com.cx.blog.dto.request.label.QueryLabelCondition;
import com.cx.blog.dto.request.label.SaveLabelRequest;
import com.cx.blog.dto.request.label.SaveRelLabelRequest;
import com.cx.blog.dto.response.LabelInfo;
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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        if (oldLabel != null && !oldLabel.getId().equals(labelId)) {
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
    public IPage<LabelInfo> queryLabelList(QueryLabelCondition condition) {
        IPage<Label> page = new Page<>(condition.getPage(), condition.getPageSize());

        IPage<LabelInfo> result = new Page<>();
        List<LabelInfo> labelInfoList = labelMapper.queryLabelList(page, condition);
        result.setTotal(page.getTotal());
        result.setRecords(labelInfoList);

        return result;
    }

    @Override
    @Transactional
    public void saveRelLabel(SaveRelLabelRequest relLabelRequest) {
        LOGGER.info("### saveRelLabel start ");

        Long relId = relLabelRequest.getRelId();
        Integer relType = relLabelRequest.getRelType();
        Assert.notNull(relType, "relType is not null");
        List<Long> labelIdList = relLabelRequest.getLabelIdList();

        // 检查标签id
        if (CollectionUtils.isEmpty(labelIdList)) {
            labelIdList = new ArrayList<>();
            labelIdList.add(Constants.DEFAULT_ARTICLE_LABEL);
        }

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

    @Override
    public List<Label> queryLabelListByRel(Integer relType, Long relId) {
        List<RelLabel> relLabelList = relLabelMapper.selectList(
            new LambdaQueryWrapper<RelLabel>().eq(RelLabel::getRelType, relType).eq(RelLabel::getRelId, relId));
        if (CollectionUtils.isEmpty(relLabelList)) {
            return new ArrayList<>();
        }

        List<Long> labelIdList = relLabelList.stream().map(RelLabel::getLabelId).collect(Collectors.toList());

        return labelMapper.selectBatchIds(labelIdList);
    }

    private LambdaQueryWrapper<Label> getLabelLambdaQueryWrapper(QueryLabelCondition condition) {
        LambdaQueryWrapper<Label> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(condition.getKeyword())) {
            queryWrapper.like(Label::getLabelName, "%" + condition.getKeyword() + "%");
        }
        return queryWrapper;
    }

}