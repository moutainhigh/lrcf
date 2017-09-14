/**
 * 
 */
package com.lrcf.yhb.user.api;


import com.lrcf.yhb.common.vo.UserMessageVo;
import com.lrcf.yhb.pojo.AccountsCenterMeassage;

import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: AccountsCenterMeassageService.java
 * @Description: 用户消息记录
 * @author:Krx
 * @date: 2017年5月11日 下午3:10:58
 */
public interface AccountsCenterMeassageService {

	/**
	 * 
	 * @Description: 插入用户消息记录
	 *
	 * @param:实体类
	 * @return：boolean
	 * @author: krx
	 * @date: 2017年5月11日 下午3:11:26
	 */
	boolean insertAccountsCenterMeassage(AccountsCenterMeassage message);

	/**
	 *
	 * @Description: 用户消息总数
	 *
	 * @param:实体类
	 * @return：boolean
	 * @author: krx
	 * @date: 2017年5月11日 下午3:11:26
	 */
	int getUserMessage(Map<String, Object> param);


	/**
	 *
	 * @Description: 用户消息列表
	 *
	 * @param:实体类
	 * @return：boolean
	 * @author: krx
	 * @date: 2017年5月11日 下午3:11:26
	 */
	List<UserMessageVo> getUserMessageList(Map<String, Object> param);


	/**
	 * 更新
	 * @param param
	 * @return
	 */
	boolean updateUserMessage(Map<String, Object> param);


	/**
	 * 删除Id
	 * @param id
	 * @return
	 */
	boolean deleteUserMessage(Integer id);

}
