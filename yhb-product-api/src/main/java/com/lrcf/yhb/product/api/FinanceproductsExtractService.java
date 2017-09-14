package com.lrcf.yhb.product.api;

import com.lrcf.yhb.common.vo.UserOutProductList;

import java.util.List;
import java.util.Map;

/**
 * 转出产品业务逻辑
 * Created by Administrator on 2017/6/7 0007.
 */
public interface FinanceproductsExtractService {

    /***
     * 转出数据总数
     * @param param
     * @return
     */
    int getOutProductCount(Map<String, Object> param);

    /***
     * 获取转出数据列表
     * @param param
     * @return
     */
    List<UserOutProductList> getOutProductList(Map<String, Object> param);
}
