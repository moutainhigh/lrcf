package com.lrcf.yhb.product.service.consumer;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
@Configuration
public class JmsConfiguration {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("ROLL_BACK_PRODUCT");
    }
}
