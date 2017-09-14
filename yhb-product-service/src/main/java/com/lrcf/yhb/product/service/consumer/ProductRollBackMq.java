package com.lrcf.yhb.product.service.consumer;

import com.alibaba.fastjson.JSONObject;
import com.lrcf.yhb.jms.api.NotifyMessageService;
import com.lrcf.yhb.product.api.FinanceproductsUsersService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Queue;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/29 0029.
 */
@Component
public class ProductRollBackMq {

    private static final Log _log = LogFactory.getLog(ProductRollBackMq.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    NotifyMessageService notifyMessageService;

    @Autowired
    FinanceproductsUsersService financeproductsUsersService;

    public void send(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

    @JmsListener(destination = "ROLL_BACK_PRODUCT")
    @Transactional(rollbackFor = {Exception.class})
    public synchronized void rollbackpro(String text) {
        Map map = JSONObject.parseObject(text);  //json转list
        if (map == null) {
            _log.info("消息为空");
            return;
        }

        System.out.println(map.get("fpuid"));
        String messageId = map.get("messageId").toString();
        //防止重复发送同一订单信息，多次回调导致多次重扣.
        if (notifyMessageService.getMessageByMessageId(messageId) == null) {
            return;
        }

        //删除数据
        if (financeproductsUsersService.deleteProduct(map.get("fpuid").toString())) {
            notifyMessageService.deleteMessageByMessageId(messageId);
            return;
        }
        //事务失败回滚
        notifyMessageService.setMessageIdToAredlyDead(messageId);
    }

}
