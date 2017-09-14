package com.lrcf.yhb.product.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.annotation.EnableJms;

/**
 * Spring boot启动类
 * Created by Krx on 2017/6/13.
 */
@EnableJms
@SpringBootApplication
@ImportResource({"classpath:dubbo-product-service.xml"})
@MapperScan(basePackages = { "com.lrcf.yhb.dao.mapper","com.lrcf.yhb.common.redis"})
public class YHBProServiceApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(YHBProServiceApplication.class, args);
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }
}
