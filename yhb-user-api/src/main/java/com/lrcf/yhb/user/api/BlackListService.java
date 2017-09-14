package com.lrcf.yhb.user.api;

import com.lrcf.yhb.pojo.BaseBankcard;
import com.lrcf.yhb.pojo.BlackList;

import java.util.List;

/**
 *
 * @ClassName: BlackListService.java
 * @Description: 黑名单用户信息
 *
 * @version: v1.0.0
 * @author: wangxf
 * @date: 2017年5月8日 下午3:24:57
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2017年5月8日     wangxf           v1.0.0               修改原因
 */
public interface BlackListService {

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
	List<BlackList> selectBlackListByAccount(String account);

	/**
	 * 查询UserId
	 *
	 * @param userId
	 * @return
	 */
	public BlackList selectBlackByUserId(String userId);

	/**
	 * 添加黑名单
	 */

	public boolean addBlackList(BlackList blackList);

}
