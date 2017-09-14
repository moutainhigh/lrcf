package com.lrcf.yhb.jms.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.annotation.EnableJms;

import java.io.IOException;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
@EnableJms
@SpringBootApplication
@ImportResource({"classpath:dubbo-jms-service.xml"})
@MapperScan(basePackages = { "com.lrcf.yhb.dao.mapper"})
public class YHBJmsServiceApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(YHBJmsServiceApplication.class, args);
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }
}
