package com.lrcf.yhb.user.api;

import com.lrcf.yhb.common.vo.YhbResult;

/**
 * 
* @ClassName: SendSmsInfoServiceImpl.java
* @Description: 短信发送相关信息统一接口
*
* @version: v1.0.0
* @author: wangxf
* @date: 2017年5月4日 下午5:29:12 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2017年5月4日     wangxf           v1.0.0               修改原因
 */
public interface SendSmsInfoService {

	/**
	 *
	 * @Function: SendSmsInfoService.java
	 * @Description: 发送短信验证码统一接口
	 *
	 * @param: smsType 验证短信的类型
	 * @param: userPhone 手机号码
	 * @return：int 短信发送的状态
	 * 			   PARAM_ERROR(19,"用户被禁发或禁用(格式，范围等不符合要求)"),
	 *             SEND_SUCCESS(0,"返回成功"), SYSTEM_BUSY(98,"系统正忙"),
	 *             PHONE_INVALID(1,"手机号码无效"), PHONE_ISNULL(14,"手机号码为空"),
	 *             IP_AUTHENT_FAILURE(20,"ip鉴权失败"),
	 *             SMS_CONTEXT_ISNULL(-101,"短信信息为空！")
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月4日 下午5:16:00
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------*
	 *        2017年5月4日 wangxf v1.0.0 修改原因
	 */
	YhbResult sendVerifySms(Integer smsType, String userPhone);

	/**
	 *
	* @Function: SendSmsInfoService.java
	* @Description: 发送短信验证码统一接口
	*
	* @param: Map<String, String> map
	* 	String context 短信信息文本
	* 	String phone 手机号码
	* 	String rand 手机验证码
	* @return：int 短信发送的状态
	* 	PARAM_ERROR(19,"用户被禁发或禁用(格式，范围等不符合要求)"),
	* 	SEND_SUCCESS(0,"返回成功"),
	* 	SYSTEM_BUSY(98,"系统正忙"),
	* 	PHONE_INVALID(1,"手机号码无效"),
	* 	PHONE_ISNULL(14,"手机号码为空"),
	* 	IP_AUTHENT_FAILURE(20,"ip鉴权失败")
	* @throws：
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月4日 下午5:16:00
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月4日     wangxf           v1.0.0               修改原因
	 */
	int sendSmsVerification(String phoneCode, String smsContext, Integer smsType, String userPhone);
	
	/**
	 * 
	* @Function: SendSmsInfoService.java
	* @Description: 生成短信信息
	*
	* @param: Integer state 要发送的短信类型
	* @return： String customSms 自定义部分的短信信息（短信的中间部分）
	* @throws：
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月5日 下午3:48:09 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月5日     wangxf           v1.0.0               修改原因
	 */
	String getSmsContextBySmsState(Integer state, String customSms);

	/**
	 *
	 * @Function: SendSmsInfoService.java
	 * @Description: 手机验证码验证 通过：true，不通过：false
	 *
	 * @param: account 手机号码
	 * @param:String phoneCode 验证码
	 * @return： boolean 通过：true，不通过：false @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月4日 上午11:07:09
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------*
	 *        2017年5月4日 wangxf v1.0.0 修改原因
	 */
	boolean checkPhoneVerifCode(String account, String phoneCode);
}
