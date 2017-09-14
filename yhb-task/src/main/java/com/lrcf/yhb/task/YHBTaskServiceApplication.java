package com.lrcf.yhb.task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring boot启动类
 * Created by Krx on 2017/6/13.
 */
@EnableScheduling
@EnableAsync
@SpringBootApplication
@ImportResource({"classpath:dubbo-task-service.xml"})
@MapperScan(basePackages = { "com.lrcf.yhb.dao.mapper"})
public class YHBTaskServiceApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(YHBTaskServiceApplication.class, args);
    }
}
