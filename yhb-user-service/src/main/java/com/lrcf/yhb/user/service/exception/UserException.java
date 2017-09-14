package com.lrcf.yhb.user.service.exception;

import com.lrcf.yhb.common.exception.BaseException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * Created by Administrator on 2017/6/28 0028.
 */
public class UserException extends BaseException {
    private static final long serialVersionUID = 3536909333010163563L;
    /** 消息内容为空 **/
    public static final int GET_MESSAGE_IS_NULL = 8001;

    /** 消息的消费队列内容为空 **/
    public static final int GET_MESSAGE_CONSUMER_QUEUE_IS_NULL = 8002;

    private static final Log LOG = LogFactory.getLog(UserException.class);

    public UserException() {
    }

    public UserException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }

    public UserException(int code, String msg) {
        super(code, msg);
    }

    public UserException print() {
        LOG.info("==>BizException, code:" + this.code + ", msg:" + this.msg);
        return this;
    }
}
