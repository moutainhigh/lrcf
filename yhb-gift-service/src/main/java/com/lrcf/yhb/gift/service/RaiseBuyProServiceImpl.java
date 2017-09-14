/**
 * 
 */
package com.lrcf.yhb.gift.service;

import com.lrcf.yhb.gift.api.RaiseBuyProService;
import com.lrcf.yhb.dao.mapper.RaiseBuyProDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**   
* Copyright: Copyright (c) 2017 LanRu-Caifu
* 
* @ClassName: RaiseBuyProServiceImpl.java
* @Description: 加息劵使用类
* @author:Krx
* @date: 2017年5月16日 上午11:06:49 
*/
@Service("raiseBuyProService")
public class RaiseBuyProServiceImpl implements RaiseBuyProService {

	@Autowired
	RaiseBuyProDao raiseBuyProDao;
}
