/**
 * 
 */
package com.lrcf.yhb.gift.service;

import com.lrcf.yhb.gift.api.ExperienceuserBuycpService;
import com.lrcf.yhb.dao.mapper.ExperienceuserBuycpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**   
* Copyright: Copyright (c) 2017 LanRu-Caifu
* 
* @ClassName: ExperienceuserBuycpServiceImpl.java
* @Description: 该类的功能描述
* @author:Krx
* @date: 2017年5月16日 上午11:05:48 
*/
@Service("experienceuserBuycpService")
public class ExperienceuserBuycpServiceImpl implements ExperienceuserBuycpService {

	@Autowired
	ExperienceuserBuycpDao experienceuserBuycpDao;
}
