package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.Agent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AgentDao {

    int deleteByPrimaryKey(@Param("userid") String userid, @Param("username") String username);

    int insert(Agent record);

    Agent selectAgentByUserName(String userName);

    Agent selectAgentByUserId(String userId);

    int insertSelective(Agent record);

    Agent selectByPrimaryKey(@Param("userid") String userid, @Param("username") String username);

    int updateByPrimaryKeySelective(Agent record);

    int updateByPrimaryKey(Agent record);

    List<Agent> selectAgentByUserState(Integer userState);

    Agent selectEmk3(@Param("emk3") String parentId);

    Agent selectByUserId(@Param("userid") String parentId);
}