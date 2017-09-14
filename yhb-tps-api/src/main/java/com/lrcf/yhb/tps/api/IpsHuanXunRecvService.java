package com.lrcf.yhb.tps.api;

import com.lrcf.yhb.common.vo.YhbResult;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public interface IpsHuanXunRecvService {
    /**
     * 注册
     * @param params
     */
     YhbResult userRegister(Map<String,String> params);

    /**
     * 充值
     * @param params
     * @return
     */
     YhbResult tradeDeposit(Map<String,String> params);

    /**
     * 提现
     * @param params
     * @return
     */
     YhbResult tradeWithdraw(Map<String,String> params);

    /**
     * 项目登记
     * @param params
     * @return
     */
     YhbResult projectRegProject(Map<String,String> params);

    /**
     * 项目追加登记
     * @param params
     * @return
     */
     YhbResult projectAssureProject(Map<String,String> params);

    /**
     * 冻结接口
     * @param params
     * @return
     */
     YhbResult tradeFreeze(Map<String,String> params);
}
