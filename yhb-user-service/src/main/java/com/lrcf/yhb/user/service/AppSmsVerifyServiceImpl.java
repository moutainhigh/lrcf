/**
 *
 */
package com.lrcf.yhb.user.service;


import com.lrcf.yhb.common.util.CompareUtils;
import com.lrcf.yhb.dao.mapper.AppSmsVerifyDao;
import com.lrcf.yhb.pojo.AppSmsVerify;
import com.lrcf.yhb.user.api.AppSmsVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 *
 * @ClassName: AppSmsVerifyServiceImpl.java
 * @Description: 该类的功能描述
 * @author:Krx
 * @date: 2017年5月5日 下午2:03:02
 */
@Service("appSmsVerifyService")
public class AppSmsVerifyServiceImpl implements AppSmsVerifyService {

	@Autowired
	AppSmsVerifyDao appSmsVerifydao;

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
	@Transactional
	@Override
	public int insertSelective(AppSmsVerify appSmsVerify) {
		return appSmsVerifydao.insertSelective(appSmsVerify);
	}

	/**
	 *
	 * @Function: AppSmsVerifyService.java
	 * @Description: 该函数的功能描述
	 *
	 * @param: AppSmsVerifyExample
	 * @return： List<AppSmsVerify>
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月8日 上午11:00:07
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月8日     wangxf           v1.0.0               修改原因
	 */
	@Override
	public List<AppSmsVerify> selectByExample(String account) {
		return appSmsVerifydao.selectByAccount(account);
	}
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
	@Transactional
	@Override
	public int updateByPrimaryKeySelective(AppSmsVerify appSmsVerify) {
		return appSmsVerifydao.updateByPrimaryKeySelective(appSmsVerify);
	}

	/**
	 *
	 * @see AppSmsVerifyService#selectVerifyIsExit(String)
	 * @Function: AppSmsVerifyServiceImpl.java
	 * @Description: 判断验证码是否存在
	 *
	 * @param:phoneCode
	 * @return：boolean
	 * @author: Krx
	 * @date: 2017年5月8日 上午9:42:39
	 */
	/*
	@Override
	public boolean selectVerifyIsExit(String phoneCode) {
		AppSmsVerifyExample example = new AppSmsVerifyExample();
		Criteria criteria = example.createCriteria();
		criteria.andMobileEqualTo(phoneCode);

		int count = appSmsVerifydao.countByExample(example);

		if (count > 0) {
			return true;
		}

		return false;
	}
*/
	/**
	 *
	 * #selectVerifyIsExit(String)
	 * @Function: AppSmsVerifyServiceImpl.java
	 * @Description: 判断验证码是否存在
	 *
	 * @param:phoneCode
	 * @return：boolean
	 * @date: 2017年5月8日 上午9:42:39
	 */
	@Override
	public boolean selectVerifyIsExit(String userPhone,String phoneCode) {
		String msg = "";
		if (phoneCode != null && !"".equals(phoneCode)) {
			List<AppSmsVerify> list = getTimeLimit(userPhone, phoneCode);
			if (list != null && list.size() > 0) {
				Date createDate = list.get(0).getCreateDate();
				Calendar rightNow = Calendar.getInstance();
				rightNow.setTime(createDate);
				rightNow.add(Calendar.MINUTE, 5);
				if (createDate != null && CompareUtils.greaterThan(rightNow.getTime(), new Date())) {
					msg = "";
				} else {
					msg = "验证码已过期";
				}
			} else {
				msg = "验证码不正确";
			}
		}

		return "".equals(msg)?true:false;
	}
	@Override
	public List<AppSmsVerify> getTimeLimit(String mobile, String verify) {
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("mobile", mobile);
		paramsMap.put("verify", verify);
		return appSmsVerifydao.getTimeLimit(paramsMap);
	}
}
