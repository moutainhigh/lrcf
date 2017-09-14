package com.lrcf.yhb.user.api;


import com.lrcf.yhb.pojo.Agent;

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
public interface AgentService {

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
	List<Agent> selectAgentForExemple();
	/**
	 * 查询代理代码是否存在
	 *
	 * @return
	 */
	public Agent selectEmk3(String parentId);
	/**
	 * 根据UserId查询代理商或员工
	 *
	 * @param parentId
	 * @return
	 */
	public Agent selectByUserId(String parentId);
}
