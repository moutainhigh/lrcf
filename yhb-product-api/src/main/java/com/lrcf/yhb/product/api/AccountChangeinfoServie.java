package com.lrcf.yhb.product.api;

import com.lrcf.yhb.pojo.AccountChangeinfo;

import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 *
 * @ClassName: AccountChangeinfoServie.java
 * @Description: 活期宝转入转出明细
 * @author:Krx
 * @date: 2017年5月11日 上午10:04:40
 */
public interface AccountChangeinfoServie {


    /**
     *
     * @Description: 活期宝转入转出List
     *
     * @param: param
     * @return： List<AccountChangeinfo>
     * @author: Krx
     * @date: 2017年5月11日 上午10:05:37
     */
    List<AccountChangeinfo> getAccountChangeinfoList(Map<String, Object> params);

    /**
     *
     * @Description:  获取活期宝转入转出条数
     *
     * @param: param
     * @return： int
     * @author: Krx
     * @date: 2017年5月11日 上午10:05:37
     */
    int countAccountChangeInfoTotal(Map<String, Object> params);


    /**
     *
     * @Description:  活期宝转入转出金额
     *
     * @param: param
     * @return： int
     * @author: Krx
     * @date: 2017年5月11日 上午10:05:37
     */
    Map<String,Object> changeCurrent(Map<String, Object> param);
}
