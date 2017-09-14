package com.lrcf.yhb.company.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Spring boot启动类
 * Created by Krx on 2017/6/13.
 */
@SpringBootApplication
@ImportResource({"classpath:dubbo-company-service.xml"})
@MapperScan(basePackages = { "com.lrcf.yhb.dao.mapper","com.lrcf.yhb.common.redis"})
public class YHBComServiceApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(YHBComServiceApplication.class, args);
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }
}
