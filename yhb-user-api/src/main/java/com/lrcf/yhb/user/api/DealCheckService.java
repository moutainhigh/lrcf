/**
 * 
 */
package com.lrcf.yhb.user.api;

import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: DealCheckService.java
 * @Description: 提现记录表
 * @author:Krx
 * @date: 2017年5月10日 下午5:36:36
 */
public interface DealCheckService {

	/**
	 * 
	 * @Description: 用户提现
	 *
	 * @param:map
	 * @return：boolean
	 * @author: krx
	 * @date: 2017年5月10日 下午5:37:30
	 */
	Map<String,String> UserWithdraw(Map<String, String> param);

}
