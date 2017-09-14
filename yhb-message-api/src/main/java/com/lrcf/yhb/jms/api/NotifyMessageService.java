package com.lrcf.yhb.jms.api;

import com.lrcf.yhb.jms.exceptions.NotifyException;
import com.lrcf.yhb.pojo.RaiseBuyPro;
import com.lrcf.yhb.pojo.RpcTransactionalMessage;

import java.util.List;

/**
 * 服务Api
 * Created by Administrator on 2017/6/27 0027.
 */
public interface NotifyMessageService {

    /**
     * 预存储消息
     * @param message
     * @return
     * @throws NotifyException
     */
    int saveMessageWaitingConfirm(RpcTransactionalMessage message) throws NotifyException;

    /**
     * 确认发送消息
     * @param messageId 消息Id
     * @throws NotifyException
     */
    void confirmAndSendMessage(String messageId) throws NotifyException;

    /**
     * 更新购买产品时没有fpuid的消息记录信息
     * @param messageId
     * @param meeagseBody
     * @throws NotifyException
     */
    void updateSendMessageBody(String messageId,String meeagseBody) throws NotifyException;

    /**
     * 存储并发送消息
     * @param message
     * @return
     * @throws NotifyException
     */
    int saveAndSendMessage(RpcTransactionalMessage message) throws NotifyException;

    /**
     * 直接发送消息
     * @param message
     * @throws NotifyException
     */
    void directSendMessage(RpcTransactionalMessage message) throws NotifyException;

    /**
     * 重新发送消息
     * @param message
     * @throws NotifyException
     */
    void reSendMessage(RpcTransactionalMessage message) throws NotifyException;

    /**
     * 根据messageId重新发送消息
     * @param messageId
     * @throws NotifyException
     */
    void reSendMessageByMessageId(String messageId) throws NotifyException;

    /**
     * 将消息标记为已失效/已死亡
     * @param messageId
     * @throws NotifyException
     */
    void setMessageIdToAredlyDead(String messageId) throws NotifyException;

    /**
     * 根据消息Id获取消息
     * @param messageId
     * @return
     * @throws NotifyException
     */
    RpcTransactionalMessage getMessageByMessageId(String messageId) throws NotifyException;

    /**
     * 根据消息Id删除消息
     * @param messageId
     * @throws NotifyException
     */
    void deleteMessageByMessageId(String messageId) throws NotifyException;

    /**
     * 重发某个消息队列中全部已死亡消息
     * @throws NotifyException
     */
    void reSendAllDeadMessageByQueueName(RpcTransactionalMessage message) throws NotifyException;

    /**
     * 获取已死亡的消息信息
     * @param status 状态
     * @param times  次数
     * @return
     */
    List<RpcTransactionalMessage> getMessageIsDeadList(String status,String times);


    /**
     * ......后续可做管理平台
     */
}
