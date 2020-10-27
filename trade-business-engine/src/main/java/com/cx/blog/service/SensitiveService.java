package com.cx.blog.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cx.storage.aliyun.service.IAPIGreenService;
import com.cx.utils.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * <文本检测方法>
 *
 * @Author: chenxin
 * @Date: 2020/10/27
 */
@Component
public class SensitiveService {

    @Reference
    private IAPIGreenService greenService;

    public boolean isSensitiveStr(String input) {
        if (StringUtils.isBlank(input)) {
            return true;
        }

        String upperCase = input.toUpperCase(Locale.ENGLISH);
        return greenService.isSensitiveWords(upperCase);
    }

}
