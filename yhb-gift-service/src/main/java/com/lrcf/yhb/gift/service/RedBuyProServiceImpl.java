/**
 * 
 */
package com.lrcf.yhb.gift.service;

import com.lrcf.yhb.gift.api.RedBuyProService;
import com.lrcf.yhb.dao.mapper.RedBuyProDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**   
* Copyright: Copyright (c) 2017 LanRu-Caifu
* 
* @ClassName: RedBuyProServiceImpl.java
* @Description: 红包购买使用类
* @author:Krx
* @date: 2017年5月16日 上午11:07:51 
*/
@Service("redBuyProService")
public class RedBuyProServiceImpl  implements RedBuyProService {
	
	@Autowired
	RedBuyProDao redBuyProDao;

}
