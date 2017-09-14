package com.lrcf.yhb.task;

import com.lrcf.yhb.jms.api.NotifyMessageService;
import com.lrcf.yhb.jms.enums.NotifyStatusEnum;
import com.lrcf.yhb.pojo.RpcTransactionalMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 创建定时任务
 * Created by Krx on 2017/6/28 0028.
 */
@Component
public class ScheduleTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    NotifyMessageService notifyMessageService;

    @Value("${task.times}")
    private String times;

    //测试方法  每次5秒运行
    @Async// 支持任务异步调用
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("----------------");
        List<RpcTransactionalMessage> messageList = notifyMessageService.getMessageIsDeadList(NotifyStatusEnum.YES.name()
                , times);
            if (messageList != null) {
                for (RpcTransactionalMessage message : messageList) {
                    notifyMessageService.reSendAllDeadMessageByQueueName(message);
                }
            }
    }




}
