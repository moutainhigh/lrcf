/**
 * 
 */
package com.lrcf.yhb.user.api;


import com.lrcf.yhb.common.vo.BankAddUpdateDatasVo;
import com.lrcf.yhb.pojo.AccountsUsers;
import com.lrcf.yhb.pojo.BaseBankcard;

import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: BaseBankcardService.java
 * @Description: 用户银行卡
 * @author:Krx
 * @date: 2017年5月12日 下午1:27:44
 */
public interface BaseBankcardService {

	/**
	 * 
	 * @Description:根据param查询银行卡信息
	 *
	 * @param:userId
	 * @return：实体类
	 * @author: Krx
	 * @date: 2017年5月12日 下午1:28:12
	 */
	BaseBankcard selectUserBankInfoByUserId(String param);

	/**
	 * 
	 * @Description:根据实体类更新用户银行卡信息
	 *
	 * @param:baseBankCard
	 * @return：boolean
	 * @author: Krx
	 * @date: 2017年5月12日 下午1:28:12
	 */
	boolean updateBankInfo(BaseBankcard baseBankCard);

	/**
	 * 
	 * @Description:根据Map添加用户银行卡信息
	 *
	 * @param:baseBankCard
	 * @return：boolean
	 * @author: Krx
	 * @date: 2017年5月12日 下午1:28:12
	 */
	boolean insertBankInfo(Map<String, String> param);

	/**
	 *
	 * @Function: BaseBankcardService.java
	 * @Description: 根据userId查询银行卡信息:加密
	 *
	 * @param: userId
	 * @return：BaseBankcard
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月13日 下午2:00:53
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月13日     wangxf           v1.0.0               修改原因
	 */
	BaseBankcard selectForMd5ByUserId(String userId);

	/**
	 *
	 * @Function: BaseBankcardService.java
	 * @Description: 绑卡统一验证接口，返回ResultEnum对应的 code
	 *
	 * @param: 用户id userId, 身份证号 idCard
	 * @return：Integer
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月13日 下午2:00:53
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月13日     wangxf           v1.0.0               修改原因
	 */
	Integer checkForTieBankCard(AccountsUsers accountsUsers, BankAddUpdateDatasVo bankInfo, String type);

	/**
	 *
	 * @Function: BaseBankcardService.java
	 * @Description: 保存用户银行卡信息
	 *
	 * @param: baseBankcard
	 * @return：Integer
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月13日 下午2:00:53
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月13日     wangxf           v1.0.0               修改原因
	 */
	Integer saveBankInfo(BaseBankcard baseBankcard);

	/**
	 *
	 * @Function: BaseBankcardService.java
	 * @Description: 保存银行卡信息前的属性设置
	 *
	 * @param: baseBankcard
	 * @return：Integer
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月13日 下午2:00:53
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月13日     wangxf           v1.0.0               修改原因
	 */
	boolean bankInfoSetAttribute(AccountsUsers accountsUsers, BankAddUpdateDatasVo bankInfoVo);
}
