package com.lrcf.yhb.user.service.consumer;

import com.alibaba.fastjson.JSONObject;
import com.lrcf.yhb.common.api.Fy.StringUtils;
import com.lrcf.yhb.common.exception.BaseException;
import com.lrcf.yhb.common.util.StringUtil;
import com.lrcf.yhb.jms.api.NotifyMessageService;
import com.lrcf.yhb.pojo.AccountsUsersBalances;
import com.lrcf.yhb.pojo.RpcTransactionalMessage;
import com.lrcf.yhb.user.api.AccountsUsersBalancesService;
import com.lrcf.yhb.user.service.exception.UserException;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.*;
import java.util.Map;

/**
 * 购买产品处理消息
 * Created by Administrator on 2017/6/27 0027.
 */
@Component
public class UserBalanceMq {
    private static final Log _log = LogFactory.getLog(UserBalanceMq.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    AccountsUsersBalancesService usersBalancesService;

    @Autowired
    NotifyMessageService notifyMessageService;

    public void send(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

    @JmsListener(destination = "BUY_PRODUCT")
    @Transactional(rollbackFor = {Exception.class})
    public synchronized void receiveQueue(String text) {
        Map map = JSONObject.parseObject(text);  //json转list
        String messageId = map.get("messageId").toString(); //取出唯一标示Id

        if (map == null) {
            _log.info("消息为空");
            notifyMessageService.setMessageIdToAredlyDead(messageId);
            return;
        }
        System.out.println("接受信息:"+text);
        if (notifyMessageService.getMessageByMessageId(messageId) == null) {
            return;
        }

        if (usersBalancesService.updateUserBalance(map)) {

            notifyMessageService.deleteMessageByMessageId(messageId);
            return;
        }

        notifyMessageService.setMessageIdToAredlyDead(messageId);
    }
}
