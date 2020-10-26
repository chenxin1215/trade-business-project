package com.cx.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;

@SpringBootApplication
@DubboComponentScan("com.cx.blog.service.impl")
@MapperScan("com.cx.blog.dao")
public class TradeBusinessEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeBusinessEngineApplication.class, args);
    }

}
