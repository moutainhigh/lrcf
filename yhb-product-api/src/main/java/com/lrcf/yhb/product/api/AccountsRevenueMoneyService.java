package com.lrcf.yhb.product.api;


import com.lrcf.yhb.pojo.AccountsRevenueMoney;

import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 *
 * @ClassName: AccountsRevenueMoneyService.java
 * @Description:活期宝收益
 * @author:Krx
 * @date 2017年05月19号
 */
public interface AccountsRevenueMoneyService {

    /***
     * 获取活期宝收益列表
     * @param params
     * @return  List<AccountsRevenueMoney>
     */
    List<AccountsRevenueMoney> getAccountsRevenueMoneyList(Map<String, Object> params);

    /***
     * 获取活期宝收益总记录数
     * @param params
     * @return int
     */
    int countRevenue(Map<String, Object> params);

}
