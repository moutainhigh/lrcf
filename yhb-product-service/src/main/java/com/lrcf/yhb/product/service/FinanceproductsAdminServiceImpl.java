/**
 * 
 */
package com.lrcf.yhb.product.service;

import com.lrcf.yhb.common.exception.BaseException;
import com.lrcf.yhb.common.util.DateUtil;
import com.lrcf.yhb.common.util.DecimalUtils;
import com.lrcf.yhb.common.util.StringUtil;
import com.lrcf.yhb.common.vo.YhbResult;
import com.lrcf.yhb.dao.mapper.FinanceproductsAdminDao;
import com.lrcf.yhb.dao.mapper.FinanceproductsUsersDao;
import com.lrcf.yhb.pojo.BaseConfig;
import com.lrcf.yhb.pojo.FinanceproductsAdmin;
import com.lrcf.yhb.product.api.FinanceproductsAdminService;
import com.lrcf.yhb.user.api.BaseConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: FinanceproductsAdminServiceImpl.java
 * @Description: 后台产品实现类
 * @author:Krx
 * @date: 2017年5月8日 下午3:43:30
 */
@Service("financeproductsAdminService")
public class FinanceproductsAdminServiceImpl implements FinanceproductsAdminService {

	private static Logger logger = LoggerFactory.getLogger(FinanceproductsAdminServiceImpl.class);

	@Autowired
	FinanceproductsAdminDao financeproductsAdminDao;
	@Autowired
	FinanceproductsUsersDao financeproductsUsersDao;
	@Autowired
	BaseConfigService baseConfigService;

	/**
	 * 
	 * @see FinanceproductsAdminService#getMainParo()
	 * @Function: FinanceproductsAdminServiceImpl.java
	 * @Description: 获取首页主推产品
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @author: Krx
	 * @date: 2017年5月8日 下午4:37:56
	 */
	@Override
	public YhbResult getMainParo() {
		Map<String, Object> resultMap = new HashMap<>();
		BigDecimal sumAdminAndUser = BigDecimal.ZERO; // 用户和管理员总共投资的钱
		BigDecimal remainMoney = BigDecimal.ZERO; // 剩余投资的金额
		BigDecimal investmentPro = BigDecimal.ZERO;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			Map<String, Object> getSeckill = baseConfigService.getSeckill();
			//产品Id
			Integer fpid = Integer.parseInt(getSeckill.get("fpid").toString());
			//状态
			Integer state = Integer.parseInt(getSeckill.get("state").toString());

			FinanceproductsAdmin fpa = financeproductsAdminDao.selectByPrimaryKey(fpid);
			if (fpa != null) {
				//sumAdminAndUser = fpa.getFproductsadminmoney().add(fpa.getFproductsusersmoney()); // 用户投的钱和管理员投的钱
				sumAdminAndUser = fpa.getInvestedMoney(); //投资金额
				remainMoney = fpa.getFproductsmaxmoney().subtract(sumAdminAndUser);// 剩余可投资金额
				investmentPro = sumAdminAndUser.divide(fpa.getFproductsmaxmoney(), 4, BigDecimal.ROUND_HALF_UP)
						.multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
				Integer count = financeproductsUsersDao.getCountUserByFPid(fpid);

				BigDecimal yearRates = DecimalUtils.getYearRates(fpa.getFproductsrates());// 年利率

				resultMap.put("name", fpa.getFproductsname()); // 产品名称
				resultMap.put("rate", yearRates);// 年利率
				resultMap.put("day", fpa.getFproductsmaxdate()); // 期限
				resultMap.put("people", count); // 已购人数
				resultMap.put("percent", investmentPro); // 已投百分比
				resultMap.put("left", remainMoney); // 剩余可投金额
				resultMap.put("id", fpa.getFpid()); // 产品ID
				resultMap.put("type", state); // 状态 0 主推 1 秒杀

				if (state == 1) {
					BaseConfig bg = baseConfigService.selectByParam("cfg_seckillFPid");
					Date d1 = sdf.parse(bg.getData()); // 活动结束时间
					Date d2 = new Date(); // 当前时间
					Date d3 = sdf.parse(bg.getValuese()); // 活动开始时间

					resultMap.put("startMillFlag", "60000");	// 秒杀开始时间变毫秒标记 :一分钟
					resultMap.put("endMillFlag", "60000");		// 秒杀结束时间变毫秒标记：一分钟
					resultMap.put("startMilliseconds", d3.getTime() - d2.getTime()); // 开始毫秒
					resultMap.put("endMilliseconds", d1.getTime() - d2.getTime());   // 结束毫秒
				}

				List<Map<String,String>> tapsList = new ArrayList<>();
				Integer type = 0;

				type =  fpa.getFproductsstate();
				//判断产品类型，假设产品不是兑换产品的情况下，状态为1,2,3,4 ，当为兑换产品时状态为5
				if(fpa.getChangestate() == 0){
					type = 5;
				}
				tapsList.add(getTaps(type)); //获取的相对应的产品类型放入list中

				resultMap.put("taps", tapsList);  //排序
				resultMap.put("min",fpa.getFproductsEk4());  //最小
				resultMap.put("total", fpa.getFproductsmaxmoney()); //最大

				return YhbResult.success(resultMap);
			}

		} catch (BaseException e) {
			logger.error("错误信息>>>" + e.getMessage());
		} catch (ParseException de) {
			logger.error("错误信息>>>" + de.getMessage());
		}

		return null;
	}

	/**
	 * 
	 * @see FinanceproductsAdminService#getMainParo()
	 * @Function: FinanceproductsAdminServiceImpl.java
	 * @Description: 获取首页产品列表
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @author: Krx
	 * @date: 2017年5月8日 下午4:37:56
	 */
	@Override
	public List<Map<String, Object>> getProList() {
		List<Map<String, Object>> resultList = new ArrayList<>();
		Map<String, Object> resultMap = null;

		List<FinanceproductsAdmin> finAdminList = financeproductsAdminDao.getIndexPro();
		if (StringUtil.isNotNull(finAdminList)) {
			Map<String, Object> getSeckill = baseConfigService.getSeckill();
			if (getSeckill.containsKey("message") && getSeckill.containsKey("code")) {
				return null;
			}
			//产品Id
			Integer fpid = Integer.parseInt(getSeckill.get("fpid").toString());

			for (FinanceproductsAdmin fpa : finAdminList) {
				if (!fpa.getFpid().equals(fpid) && StringUtil.isNotBlank(String.valueOf(fpid))) {
					resultMap = new HashMap<>();
					BigDecimal yearRates = DecimalUtils.getYearRates(fpa.getFproductsrates()); // 年利率
					//BigDecimal sumAdminAndUser = fpa.getFproductsadminmoney().add(fpa.getFproductsusersmoney()); // 用户投的钱和管理员投的钱
					BigDecimal sumAdminAndUser = fpa.getInvestedMoney(); //投资金额
					BigDecimal remainMoney = fpa.getFproductsmaxmoney().subtract(sumAdminAndUser);// 剩余可投资金额
					BigDecimal investmentPro = sumAdminAndUser
							.divide(fpa.getFproductsmaxmoney(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100))
							.setScale(2, BigDecimal.ROUND_HALF_UP);// 已投百分比

					resultMap.put("name", fpa.getFproductsname()); // 产品名称
					resultMap.put("rate", yearRates);// 年利率
					resultMap.put("day", fpa.getFproductsmaxdate()); // 期限
					resultMap.put("percent", investmentPro); // 已投百分比
					resultMap.put("left", remainMoney); // 剩余可投金额
					resultMap.put("id", fpa.getFpid()); // 产品ID
					resultMap.put("min",fpa.getFproductsEk4());  //最小
					resultMap.put("total", fpa.getFproductsmaxmoney());  //最大金额
					resultMap.put("weight", fpa.getFproductssort());  //排序

					List<Map<String, String>> tapsList = new ArrayList<>();
					Integer state = 0;

					state =  fpa.getFproductsstate();
					//判断产品类型，假设产品不是兑换产品的情况下，状态为1,2,3,4 ，当为兑换产品时状态为5
					if(fpa.getChangestate() == 0){
						state = 5;
					}
					tapsList.add(getTaps(state)); //获取的相对应的产品类型放入list中

					resultMap.put("taps", tapsList);  //排序
					resultList.add(resultMap);
			   }
			}
			return resultList;
		}

		return null;
	}


	/**
	 * 获取相对应的产品类型
	 * @param state
	 * @return
	 * @author Krx
	 */
	public Map<String,String> getTaps(Integer state){

		Map<String, String> returnMap = new HashMap<>();
		String tap ="tap";
		String color = "color";
		returnMap.put(tap, "");
        returnMap.put(color,"");
		return returnMap;

//		switch (state) {
//			case 1:
//				returnMap.put(tap, "定期");
//				returnMap.put(color, "#6a7cff");
//				break;
//			case 2:
//				returnMap.put(tap, "经销商");
//				returnMap.put(color, "#ff6967");
//				break;
//			case 3:
//				returnMap.put(tap, "新手");
//				returnMap.put(color, "#ff9a4e");
//				break;
//			case 4:
//				returnMap.put(tap, "秒杀");
//				returnMap.put(color, "#98d1ff");
//				break;
//			case 5:
//				returnMap.put(tap, "兑换");
//				returnMap.put(color, "#a498ff");
//				break;
//			default:
//				break;
//		}
//		return returnMap;
	}

	/**
	 * 根据产品Id查询产品信息
	 * @param id
	 * @return FinanceproductsAdmin
	 * @author Krx
	 */
	@Override
	public FinanceproductsAdmin selectProById(Integer id){
		FinanceproductsAdmin pro = financeproductsAdminDao.selectByPrimaryKey(id);
		if(pro!=null){
			return pro;
		}
		return null;
	}


	/**
	 * 根据产品Id查询产品详细信息
	 * @param id
	 * @return FinanceproductsAdmin
	 * @author Krx
	 */
	@Override
	public Map<String, Object> getProDeatil(Integer id) {
		Map<String, String> productItems = new HashMap(); //存储产品安全保障，回款计划，借款企业信息
		Map<String, Object> returnMap = new HashMap();  //存储所有的要返回的内容

		FinanceproductsAdmin pro = selectProById(id);
		if (StringUtil.isNotNull(pro)) {
			String enterprise = pro.getFproductsbzdes();//企业信息
			String safeInsur = pro.getFproductsdes(); //安全保险
			String receive = pro.getFproductshkdes();//回款计划

			productItems.put("enterprise", enterprise == null ? "" : enterprise);
			productItems.put("safeInsur", safeInsur == null ? "" : safeInsur);
			productItems.put("receive", receive == null ? "" : receive);


			BigDecimal sumAdminAndUser = pro.getFproductsadminmoney().add(pro.getFproductsusersmoney()); // 用户投的钱和管理员投的钱
			BigDecimal investmentPro = sumAdminAndUser.divide(pro.getFproductsmaxmoney(), 4, BigDecimal.ROUND_HALF_UP)
					.multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);//已投百分比

			returnMap.put("total",pro.getFproductsmaxmoney()); //总金额
			returnMap.put("min", pro.getFproductsEk4()); //起投金额
			returnMap.put("rate", DecimalUtils.getYearRates(pro.getFproductsrates())); //普通利率
			returnMap.put("memberRate", DecimalUtils.getYearRates(pro.getMemberrates())); //会员利率
			returnMap.put("left", pro.getFproductsmaxmoney().subtract(pro.getFproductsadminmoney().
					add(pro.getFproductsusersmoney())));//剩余金额
			returnMap.put("name", pro.getFproductsname());//产品名称
			returnMap.put("day", pro.getFproductsmaxdate()); //产品期限
			returnMap.put("percent",investmentPro); //已投百分比
			returnMap.put("time", DateUtil.formatDate(DateUtil.DEFAULT_FORMAT,pro.getFproductstimes())); //上架时间
			returnMap.put("productItems",productItems);//安全保障，借款企业信息，回款计划

			return returnMap;
		}
		return null;
	}

	/**
	 * @Description: 显示首页配置的产品
	 * @param:type=1
	 * @return：FinanceproductsAdmin
	 * @author: Krx
	 * @date: 2017年5月8日 下午3:53:53
	 */
	@Override
	public List<Map<String, Object>> getIndexPro() {
		BaseConfig bg = baseConfigService.selectByParam("cfg_onIndexPro");
		List<String> idList = new ArrayList<>();

		List<Map<String, Object>> resultList = new ArrayList<>();
		if(bg!=null && StringUtil.isNotBlank(bg.getValuese())){
			String[] strs = bg.getValuese().split(",");
			for(int i=0,len = strs.length; i<len ;i++){
                idList.add(strs[i]);
			}

			Map<String, Object> resultMap = null;
			for (String id :idList){
				FinanceproductsAdmin fpa = selectProById(Integer.parseInt(id));
				if(fpa!=null) {
					resultMap = new HashMap<String, Object>();

					BigDecimal yearRates = DecimalUtils.getYearRates(fpa.getFproductsrates()); // 年利率
					//BigDecimal sumAdminAndUser = fpa.getFproductsadminmoney().add(fpa.getFproductsusersmoney()); // 用户投的钱和管理员投的钱
					BigDecimal sumAdminAndUser = fpa.getInvestedMoney();
					BigDecimal remainMoney = fpa.getFproductsmaxmoney().subtract(sumAdminAndUser);// 剩余可投资金额
					BigDecimal investmentPro = sumAdminAndUser
							.divide(fpa.getFproductsmaxmoney(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100))
							.setScale(2, BigDecimal.ROUND_HALF_UP);// 已投百分比

					resultMap.put("name", fpa.getFproductsname()); // 产品名称
					resultMap.put("rate", yearRates);// 年利率
					resultMap.put("day", fpa.getFproductsmaxdate()); // 期限
					resultMap.put("percent", investmentPro); // 已投百分比
					resultMap.put("left", remainMoney); // 剩余可投金额
					resultMap.put("id", fpa.getFpid()); // 产品ID
					resultMap.put("min", fpa.getFproductsEk4());  //最小
					resultMap.put("total", fpa.getFproductsmaxmoney());  //最大金额
					resultMap.put("weight", fpa.getFproductssort());  //排序

					List<Map<String, String>> tapsList = new ArrayList<>();
					Integer state = 0;

					state = fpa.getFproductsstate();
					//判断产品类型，假设产品不是兑换产品的情况下，状态为1,2,3,4 ，当为兑换产品时状态为5
					if (fpa.getChangestate() == 0) {
						state = 5;
					}
					tapsList.add(getTaps(state)); //获取的相对应的产品类型放入list中

					resultMap.put("taps", tapsList);  //排序
					resultList.add(resultMap);
				}
			}
		}
		return resultList;
	}

}
