package com.lrcf.yhb.user.service;

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
@ImportResource({"classpath:dubbo-user-service.xml"})
@MapperScan(basePackages = { "com.lrcf.yhb.dao.mapper","com.lrcf.yhb.common.redis"})
public class YHBUserServiceApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(YHBUserServiceApplication.class, args);
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }
}
