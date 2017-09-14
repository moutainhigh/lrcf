package com.lrcf.yhb.user.api;


import com.lrcf.yhb.pojo.AppSmsVerify;

import java.util.List;

/**
 * 
 * @ClassName: AppSmsVerifyService.java
 * @Description: 短信验证码相关接口
 *
 * @version: v1.0.0
 * @author: wangxf
 * @date: 2017年5月4日 下午5:34:01
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2017年5月4日
 *        wangxf v1.0.0 修改原因
 */
public interface AppSmsVerifyService {

	/**
	 * 
	 * @Function: AppSmsVerifyService.java
	 * @Description: 插入验证码
	 *
	 * @param: AppSmsVerify
	 * 			@return： int @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月8日 上午10:58:37
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------*
	 *        2017年5月8日 wangxf v1.0.0 修改原因
	 */
	int insertSelective(AppSmsVerify appSmsVerify);

	/**
	 * 
	 * @Function: AppSmsVerifyService.java
	 * @Description: 更新验证码
	 *
	 * @param: AppSmsVerify
	 * 			@return： int @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月8日 上午10:59:31
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------*
	 *        2017年5月8日 wangxf v1.0.0 修改原因
	 */
	int updateByPrimaryKeySelective(AppSmsVerify appSmsVerify);

	/**
	 * 
	 * @Function: AppSmsVerifyService.java
	 * @Description: 根据手机号码
	 *
	 * @param: AppSmsVerifyExample
	 * 			@return： List<AppSmsVerify> @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月8日 上午11:00:07
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------*
	 *        2017年5月8日 wangxf v1.0.0 修改原因
	 */
	 List<AppSmsVerify> selectByExample(String account);

	/**
	 * 
	 * @Description: 查询验证码是否存在
	 *
	 * @param phoneCode
	 * @return：boolean
	 * @author: Krx
	 * @date: 2017年5月8日 下午1:31:20
	 */
	boolean selectVerifyIsExit(String userPhoen,String phoneCode);

	List<AppSmsVerify> getTimeLimit(String mobile, String verify);
}
