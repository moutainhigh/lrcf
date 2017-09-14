/**
 * 
 */
package com.lrcf.yhb.user.service;


import com.lrcf.yhb.common.enums.ResultEnum;
import com.lrcf.yhb.dao.mapper.DealCheckDao;
import com.lrcf.yhb.pojo.AccountsUsers;
import com.lrcf.yhb.user.api.AccountsUsersBalancesService;
import com.lrcf.yhb.user.api.BaseConfigService;
import com.lrcf.yhb.user.api.DealCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: DealCheckServiceImpl.java
 * @Description: 提现
 * @author:Krx
 * @date: 2017年5月10日 下午5:38:23
 */
@Service("dealCheckService")
public class DealCheckServiceImpl implements DealCheckService {

	@Autowired
	DealCheckDao dealCheckDao;
	@Autowired
	AccountsUsersBalancesService accountsUsersBalancesService;
	@Autowired
	BaseConfigService baseConfigService;

	/**
	 * @see DealCheckService#UserWithdraw(Map)
	 * @Function: DealCheckServiceImpl.java
	 * @Description: 提现接口
	 *
	 * @param:param
	 * @return：retMap
	 * @author: Krx
	 * @date: 2017年5月10日 下午5:38:44
	 */
	@Override
	public Map<String, String> UserWithdraw(Map<String, String> param) {
		// 返回的Map参数 money 提现金额 type 提现类型 提现token
		Map<String, String> retMap = new HashMap<String,String>();
        //获取用户token信息
//		AccountsUsers user = cache.getUserRedis(, 1, AccountsUsers.class);
//		RedisUtil.get(param.get("token"));
		AccountsUsers user = null;
		if(user!=null){
			//余额提现手续费
			baseConfigService.selectByParam("cfg_cashRestriction").getValue();
			baseConfigService.selectByParam("cfg_upGetMinMoney").getValue();//最少起提金额
			
			
			
		}else{
			retMap.put("code",String.valueOf(ResultEnum.TOKEN_ISNULL.getCode()));
			retMap.put("msg", ResultEnum.TOKEN_ISNULL.getCodeDesc());
		}
		return retMap;
	}

}
