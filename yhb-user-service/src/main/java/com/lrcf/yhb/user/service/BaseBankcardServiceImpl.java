/**
 * 
 */
package com.lrcf.yhb.user.service;

import com.lrcf.yhb.common.config.BaseConstants;
import com.lrcf.yhb.common.enums.ResultEnum;
import com.lrcf.yhb.common.util.DateUtil;
import com.lrcf.yhb.common.util.StringUtil;
import com.lrcf.yhb.common.vo.BankAddUpdateDatasVo;
import com.lrcf.yhb.dao.mapper.BaseBankcardDao;
import com.lrcf.yhb.pojo.AccountsUsers;
import com.lrcf.yhb.pojo.BaseBankcard;
import com.lrcf.yhb.user.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**   
* Copyright: Copyright (c) 2017 LanRu-Caifu
* 
* @ClassName: BaseBankcardServiceImpl.java
* @Description: 用户银行卡实现类
* @author:Krx
* @date: 2017年5月12日 下午1:30:29 
*/
@Service("baseBankcardService")
public class BaseBankcardServiceImpl implements BaseBankcardService {
	
	@Autowired
	BaseBankcardDao baseBankDao;
	@Autowired
	BaseConfigService baseConfigService;
	@Autowired
	AccountsUsersService accountsUsersService;
	@Autowired
	UsersBankCardErrorinfoService usersBankCardErrorinfoService;
	@Autowired
	SendSmsInfoService sendSmsInfoService;

	/** 
	* @see BaseBankcardService#selectUserBankInfoByUserId(String)
	* @Function: BaseBankcardServiceImpl.java
	* @Description: 查询用户银行卡信息
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @author: Krx
	* @date: 2017年5月12日 下午1:30:40
	*/
	@Override
	public BaseBankcard selectUserBankInfoByUserId(String param) {
		Map params = new HashMap();
		if(param.contains("userId")){
			params.put("userId",param);
		}else if(param.contains("bankcardnumber")){
			params.put("bankcardnumber",param);
		}
		return baseBankDao.selectBankByParam(params);
	}

	/**
	* @Function: BaseBankcardServiceImpl.java
	* @Description: BaseBankcardService
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @author: Krx
	* @date: 2017年5月12日 下午1:30:40
	*/
	@Override
	public boolean updateBankInfo(BaseBankcard baseBankCard) {
		if(baseBankDao.updateByPrimaryKeySelective(baseBankCard)>0){
			return true;
		}
		return false;
	}

	/**
	* @see BaseBankcardService#insertBankInfo(Map)
	* @Function: BaseBankcardServiceImpl.java
	* @Description: 根据Map添加用户银行卡信息
	*
	* @param:map中含有的信息字段一定存在baseBankInfo该表中
	* @return：返回结果描述
	* @author: Krx
	* @date: 2017年5月12日 下午1:30:40 
	*/
	@Override
	public boolean insertBankInfo(Map<String, String> param) {
      		
		return false;
	}

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
	public BaseBankcard selectForMd5ByUserId(String userId){

		if( StringUtil.isBlank(userId) ){
			return null;
		}
		return baseBankDao.selectForMd5ByUserId(userId);
	}

	/**
	 *
	 * @Function: BaseBankcardServiceImpl.java
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
	@Override
	public Integer checkForTieBankCard(AccountsUsers accountsUsers, BankAddUpdateDatasVo bankInfo, String type){

		Integer checkResult = ResultEnum.SUCCESS.getCode();

        if ( null == accountsUsers || null == bankInfo || StringUtil.isBlank(type) ) {
            return checkResult = ResultEnum.DATAS_ISNULL.getCode();
        }

		//根据用户名查询当天提交过几次错误信息
		Integer maxCount =  baseConfigService.selectByParam("cfg_bankCardMaxCount").getOrders();

		// 判断手机验证码是否匹配
		if (!sendSmsInfoService.checkPhoneVerifCode(accountsUsers.getUsername(), bankInfo.getPhoneCode())) {
			return checkResult = ResultEnum.PHONECODE_ISERROR.getCode();
		}

		//根据用户名查询当天提交过几次错误信息
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userId", accountsUsers.getUserid());
		paramMap.put("today", DateUtil.getDate(new Date()));
		Integer errorCount = usersBankCardErrorinfoService.getErrorInfoCount(paramMap);

		if( errorCount >= maxCount ){
			return checkResult = ResultEnum.TIE_CARD_ERROR_MANY.getCode();
		}

		// 验证身份证号码是否已经被注册,当新增银行卡时
        if ( BaseConstants.TIE_BANKCARD_ADD.equals(type) ) {
            boolean isExist = accountsUsersService.selectUserInfoByCardId(bankInfo.getIdCard());
            if( isExist ){
                return checkResult = ResultEnum.CARDID_ISEXISTENCE.getCode();
            }
        }

		return  checkResult;
	}

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
    public Integer saveBankInfo(BaseBankcard baseBankcard){

        Integer i = null;
        if( null != baseBankcard ){
            i = baseBankDao.insert(baseBankcard);
        }
        return i;
    }

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
    public boolean bankInfoSetAttribute(AccountsUsers accountsUsers, BankAddUpdateDatasVo bankInfoVo){

        boolean flag = true;

        if (null == accountsUsers || null == bankInfoVo ) {
            return flag = false;
        }

        accountsUsers.setCardid(bankInfoVo.getIdCard());
        accountsUsers.setTelphone(bankInfoVo.getTelPhone());

        // 产看用户是否已经绑卡
        BaseBankcard bankcard = selectUserBankInfoByUserId(accountsUsers.getUserid());
        Integer saveA = null;
        boolean saveB = false;
        if ( null != bankcard ) {
            BaseBankcard baseBankcard = new BaseBankcard();
            baseBankcard.setUserid(accountsUsers.getUserid());
            baseBankcard.setUsername(bankInfoVo.getTrueName());
            baseBankcard.setBankcardnumber(bankInfoVo.getCardId());
            baseBankcard.setBankname(bankInfoVo.getBankId());
            baseBankcard.setProvince(bankInfoVo.getProId());
            baseBankcard.setCity(bankInfoVo.getCityId());
            baseBankcard.setBankaddress(bankInfoVo.getBranch());
            baseBankcard.setBankaddress2(bankInfoVo.getSubbranch());
            baseBankcard.setCreatetime(new Date());
            baseBankcard.setIspass(1);
            baseBankcard.setIsused(true);
            baseBankcard.setRemark("用户绑定银行卡");
            baseBankcard.setBelong(0);

            saveA = saveBankInfo(baseBankcard);

        } else {

            bankcard.setUserid(accountsUsers.getUserid());
            bankcard.setUsername(bankInfoVo.getTrueName());
            bankcard.setBankcardnumber(bankInfoVo.getCardId());
            bankcard.setBankname(bankInfoVo.getBankId());
            bankcard.setProvince(bankInfoVo.getProId());
            bankcard.setCity(bankInfoVo.getCityId());
            bankcard.setBankaddress(bankInfoVo.getBranch());
            bankcard.setBankaddress2(bankInfoVo.getSubbranch());
            bankcard.setCreatetime(new Date());
            bankcard.setIspass(1);
            bankcard.setIsused(true);
            bankcard.setRemark("用户更换银行卡");
            bankcard.setBelong(0);

            saveB = updateBankInfo(bankcard);

        }
        boolean saveC = accountsUsersService.updateUserInfo(accountsUsers);

        if( null == saveA || !saveB || !saveC ){
            flag = false;
        }
        return flag;
    }
}
