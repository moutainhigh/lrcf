/**
 *
 */
package com.lrcf.yhb.user.api;

import com.lrcf.yhb.common.vo.YhbResult;
import com.lrcf.yhb.dto.RegistDTO;
import com.lrcf.yhb.pojo.AccountsUsers;

import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 *
 * @ClassName: AccountsUsersService.java
 * @Description: 用户接口
 * @author:Krx
 * @date: 2017年4月27日 下午1:50:34
 */
public interface AccountsUsersService {

	/**
	 *
	 * @Description: 根据UserName获取AccountsUsers
	 *
	 * @param:userName
	 * @return
	 * @author: Krx
	 * @date: 2017年4月27日 下午2:22:52
	 */
	AccountsUsers selectUserByUserName(String userName);

	/**
	 * 根据Ips商户账号查询用户信息
	 * @param ipsAcctNo
	 * @return
	 */
	AccountsUsers selectIpsAcctNo(String ipsAcctNo);

	/**
	 *
	 * @Description: 根据userId获取AccountsUsers
	 *
	 * @param:userId
	 * @return：AccountsUsers
	 * @author: Krx
	 * @date: 2017年5月8日 上午9:15:30
	 */
	AccountsUsers selectUserByPrimaryKey(String userId);

	/**
	 *
	 * @Function: AccountsUsersService.java
	 * @Description: 用户注册-Service
	 *
	 * @param: Map<String,
	 *             String>
	 * @return：AccountsUsers @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月4日 上午10:11:46
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------*
	 *        2017年5月4日 wangxf v1.0.0 修改原因
	 */
	YhbResult register(Map<String, String> registerMap);

	/**
	 *
	 * @Function: AccountsUsersService.java
	 * @Description: 用户注册-Service
	 *
	 * @param: Map<String,
	 *             String>
	 * @return：AccountsUsers @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月4日 上午10:11:46
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------*
	 *        2017年5月4日 wangxf v1.0.0 修改原因
	 */
	AccountsUsers registers(Map<String, String> registerMap);

	/**
	 *
	 * @Description: 查询用户列表信息
	 *
	 * @param:example
	 * @return：List<AccountsUsers>
	 * @author: Krx
	 * @date: 2017年5月8日 上午9:17:50
	 */
	//List<AccountsUsers> selectByExample(AccountsUsersExample example);

	/**
	 *
	 * @Description: 插入用户信息
	 *
	 * @param:users
	 * @return：int
	 * @author: Krx
	 * @date: 2017年5月8日 上午9:17:50
	 */
	int insertSelectiveUsers(AccountsUsers users);

	/**
	 *
	 * @Description: 更新用户信息
	 *
	 * @param:registerMap
	 * @return：boolean
	 * @author: Krx
	 * @date: 2017年5月9日 上午10:50:39
	 */
	boolean updateUserInfo(Map<String, String> registerMap);

	/**
	 *
	 * @Function: AccountsUsersService.java
	 * @Description: 用户上传头像
	 *
	 * @param: AccountsUsers accountsUsers
	 * @return： boolean
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月11日 下午3:20:29
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月11日     wangxf           v1.0.0               修改原因
	 */
	boolean updateUserInfo(AccountsUsers accountsUsers);

	/**
	 *
	 * @Function: AccountsUsersService.java
	 * @Description: 判断身份证号码是否已经被注册
	 *
	 * @param: AccountsUsers accountsUsers
	 * @return： boolean
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月11日 下午3:20:29
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月11日     wangxf           v1.0.0               修改原因
	 */
	boolean selectUserInfoByCardId(String cardId);

	/**
	 * 登录
	 * @param  userName, pwd
	 * @return
	 */
	YhbResult login(String userName, String pwd, String type);

	/**
	 * 根据token值获取用户信息
	 * @param token
	 * @return
	 */
	YhbResult token(String token);

	/**
	 * 请求格式 POST
	 * 验证验证码
	 *
	 * @param authCode 输入的验证码
	 * @param uuid Redis验证码uuid
	 * @return {
	 *           "success": 0 可用 1 不可用
	 *         }
	 */
	//@POST
	//@Path("/validate/validateuser")
	String validateAuthCode(String authCode, String uuid);

	/**
	 * 注册
	 * @return
	 */
	YhbResult register(RegistDTO registDTO);

	String registerLimit(String parentId);
}
