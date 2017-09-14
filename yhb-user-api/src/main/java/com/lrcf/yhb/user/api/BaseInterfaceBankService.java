/**
 * 
 */
package com.lrcf.yhb.user.api;


import com.lrcf.yhb.pojo.BaseInterfaceBank;

import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: BaseInterfaceBankService.java
 * @Description: 银行接口
 * @author:Krx
 * @date: 2017年5月9日 下午1:43:27
 */
public interface BaseInterfaceBankService {

	/**
	 * 
	 * @Description:根据银行代码查询银行
	 *
	 * @param:String bankcode
	 * @return：实体类
	 * @author: Krx
	 * @date: 2017年5月9日 下午1:44:19
	 */
	BaseInterfaceBank selectBankNumByBankCode(String bankCode);

	/**
	 *
	 * @Function: BaseInterfaceBankService.java
	 * @Description: 查询所有可以绑卡的银行列表
	 *
	 * @param:
	 * @return：
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月13日 下午3:37:00
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月13日     wangxf           v1.0.0               修改原因
	 */
	List<BaseInterfaceBank> selectBankList();

	/**
	 *
	 * @Function: BaseInterfaceBankService.java
	 * @Description: 拼接银行卡类表信息：{ value: '', //代号 label: '' //银行名  }
	 *
	 * @param: List<BaseInterfaceBank>
	 * @return： List<Map<String, Object>>
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月13日 下午4:33:48
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月13日     wangxf           v1.0.0               修改原因
	 */
	List<Map<String,Object>> getBankReturnJson(List<BaseInterfaceBank> bankList);

	/**
	 *
	 * @Function: BaseInterfaceBankService.java
	 * @Description: 封装银行卡信息出参json，当前用户已有银行卡信息 ： selected + 银行卡信息列表： list
	 *
	 * @param:userId
	 * @return： Map<String, Object>
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月16日 上午10:12:50
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月16日     wangxf           v1.0.0               修改原因
	 */
	Map<String, Object> getBankMapForJson(String userId);

	/**
	 *
	 * @Function: BaseInterfaceBankService.java
	 * @Description: 通过userid获取用户的银行卡信息
	 *
	 * @param: userId
	 * @return： BaseInterfaceBank
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月16日 下午2:46:49
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月16日     wangxf           v1.0.0               修改原因
	 */
	BaseInterfaceBank selectBankInfoForUserId(String userId);
}
