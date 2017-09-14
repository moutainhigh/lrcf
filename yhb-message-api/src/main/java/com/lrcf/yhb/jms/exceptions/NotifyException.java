package com.lrcf.yhb.jms.exceptions;

import com.lrcf.yhb.common.exception.BaseException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 消息异常类
 * Created by Administrator on 2017/6/27 0027.
 */
public class NotifyException  extends BaseException{
    private static final long serialVersionUID = 3536909333010163563L;
    /** 保存的消息为空 **/
    public static final int SAVA_MESSAGE_IS_NULL = 8001;

    /** 消息的消费队列为空 **/
    public static final int MESSAGE_CONSUMER_QUEUE_IS_NULL = 8002;

    private static final Log LOG = LogFactory.getLog(NotifyException.class);

    public NotifyException() {
    }

    public NotifyException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }

    public NotifyException(int code, String msg) {
        super(code, msg);
    }

    public NotifyException print() {
        LOG.info("==>BizException, code:" + this.code + ", msg:" + this.msg);
        return this;
    }

}
