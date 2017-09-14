package com.lrcf.yhb.user.service;


import com.lrcf.yhb.dao.mapper.AgentDao;
import com.lrcf.yhb.pojo.Agent;
import com.lrcf.yhb.user.api.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
* @ClassName: AgentService.java
* @Description: 代理商信息接口
*
* @version: v1.0.0
* @author: wangxf
* @date: 2017年5月9日 下午4:41:24 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2017年5月9日     wangxf           v1.0.0               修改原因
 */
@Service("agentService")
public class AgentServiceImpl implements AgentService {
	
	@Autowired
	AgentDao agentDao;

	/**
	 * 
	* @Function: AgentService.java
	* @Description: 获取代理商信息
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月9日 下午4:42:25 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月9日     wangxf           v1.0.0               修改原因
	 */
	@Override
	public List<Agent> selectAgentForExemple(){
		List<Agent> agentList = agentDao.selectAgentByUserState(1);
		return agentList;
	}
	@Override
	public Agent selectEmk3(String parentId ) {
		return this.agentDao.selectEmk3(parentId);
	}
	@Override
	public Agent selectByUserId(String parentId) {
		return this.agentDao.selectByUserId( parentId);
	}
}
