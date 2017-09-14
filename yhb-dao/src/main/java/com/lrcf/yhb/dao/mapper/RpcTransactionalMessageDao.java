package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.RpcTransactionalMessage;

import java.util.List;
import java.util.Map;

public interface RpcTransactionalMessageDao {
    int deleteByPrimaryKey(String id);

    int insert(RpcTransactionalMessage record);

    int insertSelective(RpcTransactionalMessage record);

    RpcTransactionalMessage selectByPrimaryKey(String id);
    //根据消息Id查询消息
    RpcTransactionalMessage selectByMessageId(String messageId);
    //删除消息根据消息ID
    int deleteByMessageId(String messageId);
    //查询已死亡队列排除掉限制
    List<RpcTransactionalMessage> selectByStatusAndTimes(Map param);

    int updateByPrimaryKeySelective(RpcTransactionalMessage record);

    int updateByPrimaryKey(RpcTransactionalMessage record);
}