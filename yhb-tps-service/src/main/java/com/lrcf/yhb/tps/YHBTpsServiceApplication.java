package com.lrcf.yhb.tps;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.annotation.EnableJms;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
@EnableJms
@SpringBootApplication
@ImportResource({"classpath:dubbo-tps-service.xml"})
@MapperScan(basePackages = { "com.lrcf.yhb.dao.mapper"})
public class YHBTpsServiceApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(YHBTpsServiceApplication.class, args);
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }
}
