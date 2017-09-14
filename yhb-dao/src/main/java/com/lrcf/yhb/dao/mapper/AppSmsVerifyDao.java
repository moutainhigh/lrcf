package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.AppSmsVerify;

import java.util.List;
import java.util.Map;

public interface AppSmsVerifyDao {
	
	/**
	 * 
	* @Function: AppSmsVerifyService.java
	* @Description: 插入验证码
	*
	* @param: AppSmsVerify
	* @return： int
	* @throws： 
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月8日 上午10:58:37 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月8日     wangxf           v1.0.0               修改原因
	 */
	int insertSelective(AppSmsVerify appSmsVerify);
	
	/**
	 * 
	* @Function: AppSmsVerifyService.java
	* @Description: 更新验证码
	*
	* @param: AppSmsVerify
	* @return： int
	* @throws：
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月8日 上午10:59:31 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月8日     wangxf           v1.0.0               修改原因
	 */
	int updateByPrimaryKeySelective(AppSmsVerify appSmsVerify);

	/**
	 *
	 * @Function: AppSmsVerifyService.java
	 * @Description:查询用户短信验证码
	 *
	 * @param: AppSmsVerify
	 * @return： int
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月8日 上午10:59:31
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月8日     wangxf           v1.0.0               修改原因
	 */
	List<AppSmsVerify> selectByAccount(String account);
	List<AppSmsVerify> getTimeLimit(Map<String, String> paramsMap);
}