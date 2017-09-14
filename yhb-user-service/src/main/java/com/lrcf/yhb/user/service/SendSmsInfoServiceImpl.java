package com.lrcf.yhb.user.service;


import com.lrcf.yhb.common.enums.ResultEnum;
import com.lrcf.yhb.common.enums.SendSmsStateEnum;
import com.lrcf.yhb.common.util.StringUtil;
import com.lrcf.yhb.common.util.StringUtils;
import com.lrcf.yhb.common.vo.YhbResult;
import com.lrcf.yhb.pojo.AppSmsVerify;
import com.lrcf.yhb.user.api.AppSmsVerifyService;
import com.lrcf.yhb.user.api.SendSmsInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 
 * @ClassName: SendSmsInfoServiceImpl.java
 * @Description: 短信发送相关信息统一接口
 *
 * @version: v1.0.0
 * @author: wangxf
 * @date: 2017年5月4日 下午5:29:12
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2017年5月4日
 *        wangxf v1.0.0 修改原因
 */
@Service("sendSmsInfoService")
public class SendSmsInfoServiceImpl implements SendSmsInfoService {

	private static Logger logger = LoggerFactory.getLogger(SendSmsInfoServiceImpl.class);
	@Autowired
	AppSmsVerifyService appSmsVerifyService;

	/**
	 * 
	 * @Function: SendSmsInfoService.java
	 * @Description: 生成短信信息
	 *
	 * @param: Integer
	 *             state 要发送的短信类型 @return： String customSms
	 *             自定义部分的短信信息（短信的中间部分） @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月5日 下午3:48:09
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------*
	 *        2017年5月5日 wangxf v1.0.0 修改原因
	 */
	@Override
	public String getSmsContextBySmsState(Integer state, String customSms) {

		logger.info("生成短信信息！");
		// 短信信息
		String smsContext = "";

		// 判断要发送的短信的类型状态是否合法
		if (null != state && state >= 0) {
			SendSmsStateEnum sendSmsStateEnum = SendSmsStateEnum.getCodeDescByCode(state);
			// 获取短信前缀
			String smsPrefix = sendSmsStateEnum.getCodeDesc().getSmsPrefix();
			// 获取短信后缀
			String smsSuffix = sendSmsStateEnum.getCodeDesc().getSmsSuffix();

			smsContext += smsPrefix + customSms + smsSuffix;
		}

		return smsContext;
	}

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
	public YhbResult sendVerifySms(Integer smsType, String userPhone){
		// 发送短信验证码统一接口
		int sendSmsState = 98;

		//判断手机号码是否为空
		if (StringUtils.isBlank(userPhone)) {
			return YhbResult.build(ResultEnum.PHONE_ISNULL.getCode(), ResultEnum.PHONE_ISNULL.getCodeDesc());
		}
		//判断发送状态是否为空
		if (StringUtil.isBlank(smsType)) {
			return YhbResult.build(ResultEnum.SMS_STATE_ERROR.getCode(), ResultEnum.SMS_STATE_ERROR.getCodeDesc());
		}

		// 生成验证码
		String phoneCode = String.valueOf(Math.random()).substring(2).substring(0, 5);
		// 调用短信接口，生成短信信息
		String smsContext = getSmsContextBySmsState(smsType, String.valueOf(phoneCode));
        //判断短信是否发送成功
		sendSmsState = sendSmsVerification(phoneCode, smsContext, smsType, userPhone);
		if (sendSmsState == 0) {
			return YhbResult.build(ResultEnum.SMS_SEND_SUCCESS.getCode(), ResultEnum.SMS_SEND_SUCCESS.getCodeDesc());
		}else{
			return YhbResult.build(sendSmsState, ResultEnum.getResultEnumByCode(sendSmsState).getCodeDesc());
		}
	}

	/**
	 *
	 * @Function: SendSmsInfoServiceImpl.java
	 * @Description: 发送短信验证码统一接口
	 *
	 * @param: Map<String,String> map String context 短信信息文本 String phone 手机号码 String rand 手机验证码
	 * @return：int 短信发送的状态 PARAM_ERROR(19,"用户被禁发或禁用(格式，范围等不符合要求)"),
	 *             SEND_SUCCESS(0,"返回成功"), SYSTEM_BUSY(98,"系统正忙"),
	 *             PHONE_INVALID(1,"手机号码无效"), PHONE_ISNULL(14,"手机号码为空"),
	 *             IP_AUTHENT_FAILURE(20,"ip鉴权失败")
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
	@Override
	public int sendSmsVerification(String phoneCode,String smsContext,Integer smsType,String userPhone) {
		// 发送短信发送的状态值
		int sendSmsState = 98;

		// 判断是否发送纯文本短信 默认为0，发送验证码短信
		if (smsType == 1) {
			// 调用发送“大汉三通发送短信信息”
//			sendSmsState = SendSMS.sendSingleSMSForInt(smsContext, userPhone);
			logger.info("发送纯文本短信,内容:"+smsContext+",账号为:"+phoneCode);
			return  sendSmsState;
		}

		//短信验证码必备 phoncode
		// 如果短信发送成功：0，保存生成的验证码,表：app_sms_verify
		List<AppSmsVerify> appSmsVerifieList = null;
		if (sendSmsState == 0) {
			logger.info("调用第三方发送短信成功！");
			// 查询该用户是否已经发送过短信验证码
			appSmsVerifieList = appSmsVerifyService.selectByExample(userPhone);
		} else {
			logger.debug("调用第三方发送短信失败！");
			return sendSmsState;
		}

		int i = 0;
		AppSmsVerify appSmsVerify = null;
		// 判断给用户是否已经发送过验证码
		if (null != appSmsVerifieList && appSmsVerifieList.size() > 0
				&& null != (appSmsVerify = appSmsVerifieList.get(0))) {
			// 更新验证码
			appSmsVerify.setVerify(phoneCode);
			i = appSmsVerifyService.updateByPrimaryKeySelective(appSmsVerify);
		} else {
			appSmsVerify = new AppSmsVerify();
			appSmsVerify.setMobile(userPhone);
			appSmsVerify.setCreateDate(new Date());
			appSmsVerify.setVerify(phoneCode);
			i = appSmsVerifyService.insertSelective(appSmsVerify);
		}
		// 打印日志信息
		if (i == 1) {
			logger.info("用户短信验证码添加成功！");
		} else {
			logger.info("用户短信验证码添加失败！");
		}

		return sendSmsState;
	}

	/**
	 *
	 * @Function: SendSmsInfoServiceImpl.java
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
	@Override
	public boolean checkPhoneVerifCode(String account, String phoneCode) {
		// 手机号码，验证码不能为空
		if (StringUtil.isBlank(account) || StringUtil.isBlank(phoneCode)) {
			return false;
		}

		// 通过手机号码获取验证码
		List<AppSmsVerify> appSmsVerifieList = appSmsVerifyService.selectByExample(account);

		if (null == appSmsVerifieList || appSmsVerifieList.size() < 1) {
			return false;
		}
		// 判断验证码是否正确
		if (phoneCode.equals(appSmsVerifieList.get(0).getVerify())) {
			return true;
		}
		return false;
	}
}
