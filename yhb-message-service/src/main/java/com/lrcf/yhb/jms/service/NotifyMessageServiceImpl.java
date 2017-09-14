package com.lrcf.yhb.jms.service;

import com.alibaba.fastjson.JSON;
import com.lrcf.yhb.common.api.Fy.StringUtils;
import com.lrcf.yhb.common.exception.BaseException;
import com.lrcf.yhb.common.util.StringUtil;
import com.lrcf.yhb.dao.mapper.RpcTransactionalMessageDao;
import com.lrcf.yhb.jms.api.NotifyMessageService;
import com.lrcf.yhb.jms.enums.NotifyStatusEnum;
import com.lrcf.yhb.jms.enums.NotifyTypeEnum;
import com.lrcf.yhb.jms.exceptions.NotifyException;
import com.lrcf.yhb.pojo.RpcTransactionalMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 消息服务中心逻辑业务
 * @Author 孔荣勋【Krx】
 * @Date 2017/6/27 0027 14:31
*/
@Service("notifyMessageService")
public class NotifyMessageServiceImpl implements NotifyMessageService {

    private static final Log log = LogFactory.getLog(NotifyMessageServiceImpl.class);

    @Autowired
    private RpcTransactionalMessageDao messageDao;

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 预存储消息
     *
     * @param message
     * @return
     * @throws NotifyException
     */
    @Override
    public int saveMessageWaitingConfirm(RpcTransactionalMessage message) throws NotifyException {

        if (message == null) {
            throw new NotifyException(NotifyException.SAVA_MESSAGE_IS_NULL, "保存的消息为空");
        }

        if (StringUtils.isEmpty(message.getConsumerQueue())) {
            throw new NotifyException(NotifyException.MESSAGE_CONSUMER_QUEUE_IS_NULL, "消息的消费队列不能为空");
        }

        //创一条消息但不执行业务，默认消息状态为待确认，未死亡状态，重发次数为1
        message.setEditTime(new Date());
        message.setStatus(NotifyStatusEnum.WAITING_CONFIRM.name());
        message.setAreadlyDead(NotifyStatusEnum.NO.name());
        message.setMessageSendTimes(0);
        message.setRemark("创建消息，消息初始化");

        System.out.println("创建消息"+message);

        return messageDao.insertSelective(message);
    }

    /**
     * 确认发送消息
     *
     * @param messageId 消息Id
     * @throws NotifyException
     */
    @Override
    public void confirmAndSendMessage(String messageId) throws NotifyException {
        final RpcTransactionalMessage message = getMessageByMessageId(messageId);

        if (message == null) {
            throw new NotifyException(NotifyException.SAVA_MESSAGE_IS_NULL, "根据消息ID查找的消息为空");
        }

        //当发送消息时更改消息状态为发送中，更改修改时间，更新数据库
        message.setStatus(NotifyStatusEnum.SENDING.name());
        message.setEditTime(new Date());
        message.setRemark("事务已执行，消息正发送中");
        messageDao.updateByPrimaryKeySelective(message);

        System.out.println("处理消息发送消息"+message);
        //发送消息，根据消息队列名称，发送消息内容
        jmsTemplate.setDefaultDestinationName(message.getConsumerQueue());
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message.getMessageBody());
            }
        });
    }

    /**
     * 更新购买产品时没有fpuid的消息记录信息
     *
     * @param messageId
     * @param meeagseBody
     * @throws NotifyException
     */
    @Override
    public void updateSendMessageBody(String messageId, String meeagseBody) throws NotifyException {

        if (StringUtils.isEmpty(meeagseBody) || StringUtils.isEmpty(messageId)) {
            throw new NotifyException(NotifyException.SAVA_MESSAGE_IS_NULL, "更新的消息内容为空");
        }

        RpcTransactionalMessage message = getMessageByMessageId(messageId);
        message.setMessageBody(meeagseBody);
        message.setEditTime(new Date());
        message.setRemark("事务执行失败，消息轮询超限，正在执行回滚事务中");
        messageDao.updateByPrimaryKeySelective(message);
    }

    /**
     * 存储并发送消息
     *
     * @param message
     * @return
     * @throws NotifyException
     */
    @Override
    public int saveAndSendMessage(final RpcTransactionalMessage message) throws NotifyException {

        if (message == null) {
            throw new NotifyException(NotifyException.SAVA_MESSAGE_IS_NULL, "保存的消息为空");
        }

        if (StringUtils.isEmpty(message.getConsumerQueue())) {
            throw new NotifyException(NotifyException.MESSAGE_CONSUMER_QUEUE_IS_NULL, "消息的消费队列不能为空");
        }

        //直接存储信息
        message.setStatus(NotifyStatusEnum.SENDING.name());
        message.setAreadlyDead(NotifyStatusEnum.NO.name());
        message.setMessageSendTimes(0);
        message.setEditTime(new Date());
        message.setRemark("更改消息状态，事务状态初始化，发送消息，告知另一系统处理消息中");
        int result = messageDao.insertSelective(message);

        log.info("消息队列名称:" + message.getConsumerQueue());
        System.out.println("处理消息发送消息"+message);
        //发送消息，根据消息队列名称，发送消息内容
        jmsTemplate.setDefaultDestinationName(message.getConsumerQueue());
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message.getMessageBody());
            }
        });

        return result;
    }

    /**
     * 直接发送消息
     *
     * @param message
     * @throws NotifyException
     */
    @Override
    public void directSendMessage(RpcTransactionalMessage message) throws NotifyException {

    }

    /**
     * 重新发送消息
     *
     * @param message
     * @throws NotifyException
     */
    @Override
    public void reSendMessage(RpcTransactionalMessage message) throws NotifyException {

    }

    /**
     * 根据messageId重新发送消息
     *
     * @param messageId
     * @throws NotifyException
     */
    @Override
    public void reSendMessageByMessageId(String messageId) throws NotifyException {

    }

    /**
     * 将消息标记为已失效/已死亡
     *
     * @param messageId
     * @throws NotifyException
     */
    @Override
    public void setMessageIdToAredlyDead(String messageId) throws NotifyException {
        RpcTransactionalMessage message = getMessageByMessageId(messageId);
        message.setAreadlyDead(NotifyStatusEnum.YES.name());
        message.setRemark("事务执行因未知原因失败，消息进入轮询状态，状态已死亡");
        messageDao.updateByPrimaryKeySelective(message);
    }

    /**
     * 根据消息Id获取消息
     *
     * @param messageId
     * @return
     * @throws NotifyException
     */
    @Override
    public RpcTransactionalMessage getMessageByMessageId(String messageId) throws NotifyException {
        return messageDao.selectByMessageId(messageId);
    }

    /**
     * 根据消息Id删除消息
     *
     * @param messageId
     * @throws NotifyException
     */
    @Override
    public void deleteMessageByMessageId(String messageId) throws NotifyException {
        messageDao.deleteByMessageId(messageId);
    }

    /**
     * 重发某个消息队列中全部已死亡消息
     *
     * @throws NotifyException
     */
    @Override
    public void reSendAllDeadMessageByQueueName(RpcTransactionalMessage message) throws NotifyException {

        if (message == null) {
            System.out.println("参数为空");
            return;
        }

        //当重发次数大于5次以上，就回滚掉上次操作
        if(message.getMessageSendTimes() == 5){
            message.setConsumerQueue(NotifyTypeEnum.ROLL_BACK_PRODUCT.name());
            message.setRemark("事务执行失败，消息轮询超限，正告知上一系统回滚事务中");
        }else {
            //如果消息在5次或者是5次之内，则继续消息重发操作，
            // 状态是已死亡，当事务执行成功，此消息删除销毁.
            message.setMessageSendTimes(message.getMessageSendTimes() + 1);
            message.setRemark("消息轮询中，该消息被执行" + message.getMessageSendTimes() + "次");
        }

        message.setEditTime(new Date());
        messageDao.updateByPrimaryKeySelective(message);

        System.out.println(message.getConsumerQueue());
         //发送消息，根据消息队列名称，发送消息内容
         jmsTemplate.setDefaultDestinationName(message.getConsumerQueue());
         jmsTemplate.send(new MessageCreator() {
           public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message.getMessageBody());
           }
         });
    }


    /**
     * 获取已死亡的消息信息
     * @param status 状态
     * @param times  次数
     * @return
     */
    @Override
    public List<RpcTransactionalMessage> getMessageIsDeadList(String status, String times) {

        if (StringUtils.isEmpty(status) || StringUtils.isEmpty(times)) {
            System.out.println("参数为空");
            return null;
        }

        Map<String, String> param = new HashMap<String, String>();
        param.put("status", status);
        param.put("times", times);

        List<RpcTransactionalMessage> messageList = messageDao.selectByStatusAndTimes(param);
        if (messageList.size() == 0) {
            return null;
        }
        return messageList;
    }
}
