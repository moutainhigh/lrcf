package com.lrcf.yhb.user.service;


import com.lrcf.yhb.dao.mapper.BlackListDao;
import com.lrcf.yhb.pojo.BaseBankcard;
import com.lrcf.yhb.pojo.BlackList;
import com.lrcf.yhb.user.api.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("blackListService")
public class BlackListServiceImpl implements BlackListService {

	@Autowired
	BlackListDao blackListDao;

	/**
	 *
	 * @Function: AccountsUsersService.java
	 * @Description: 通过手机号码获取黑名单用户信息
	 *
	 * @param: String account 手机号码
	 * @return： 黑名单用户列表
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月8日 下午3:22:28
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月8日     wangxf           v1.0.0               修改原因
	 */
	@Override
	public List<BlackList> selectBlackListByAccount(String account) {
		return blackListDao.selectByPhone(account);
	}
	@Override
	public BlackList selectBlackByUserId(String userId) {
		return this.blackListDao.selectBlackByUserId(userId);
	}

	@Override
	public boolean addBlackList(BlackList blackList) {
		return this.blackListDao.insertSelective(blackList);
	}
}
