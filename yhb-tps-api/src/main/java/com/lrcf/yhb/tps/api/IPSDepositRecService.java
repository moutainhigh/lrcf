package com.lrcf.yhb.tps.api;

import com.lrcf.yhb.common.vo.YhbResult;

import java.util.Map;

/**
 * 环迅平台支付
 * Created by Krx on 2017/7/24 0024.
 */
public interface IPSDepositRecService {

    /**
     * test测试
     * @return
     */
    YhbResult test();

    /**
     * 用户注册
     *
     * @param
     * @return
     * @throws Exception
     */
    Map<String, String> userRegister(Map<String,String> param) throws Exception;

    /**
     * 商户直连银行查询
     *
     * @param
     * @return
     * @throws Exception
     */
    Map<String, String> queryBankQuery() throws Exception;
    /**
     *  查询接口
     *  查询接口主要为互联网金融平台进行账户和交易查询使用。
     * @return
     * @throws Exception
     */
    Map<String,String> queryCommonQuery(Map<String,String> param) throws Exception;
    /**
     * 用户登录
     *
     * @param
     * @return
     * @throws Exception
     */
    Map<String, String> userLogin(String username) throws Exception;

    /**
     * 用户充值
     * @param
     *
     */
    Map<String, String> tradeDeposit(Map<String,String> p)throws Exception;
    /**
     * 用户提现接口
     * @param p
     * @return
     * @throws Exception
     */
    Map<String,String> tradeWithdraw(Map<String,String> p) throws Exception;
    /**
     * 用户转账
     * @param param
     * @return
     * @throws Exception
     */
    Map<String,String> tradeTransfer(Map<String,String> param) throws Exception;
    /**
     * 用户冻结接口
     * @param param
     * @return
     * @throws Exception
     */
    Map<String,String> tradeFreeze(Map<String,String> param) throws Exception;
    /**
     * 用户解冻接口
     * @param p
     * @return
     * @throws Exception
     */
    Map<String,String> tradeUnFreeze(Map<String,String> p) throws Exception;
    /**
     * 项目登记接口
     * @return
     * @throws Exception
     */
    Map<String,String> projectRegProject(Map<String,String> p) throws Exception;
    /**
     * 项目追加登记接口
     * @return
     * @throws Exception
     */
    Map<String,String> projectAssureProject(Map<String,String> p) throws Exception;
    /**
     * 红包组合冻结接口
     * @return
     * @throws Exception
     */
    Map<String,String> tradeCombFreeze(Map<String,String> p) throws Exception;

}
