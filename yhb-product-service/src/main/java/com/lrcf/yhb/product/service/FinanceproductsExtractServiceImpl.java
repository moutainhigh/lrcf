package com.lrcf.yhb.product.service;

import com.lrcf.yhb.common.vo.UserOutProductList;
import com.lrcf.yhb.dao.mapper.FinanceproductsExtractDao;
import com.lrcf.yhb.product.api.FinanceproductsExtractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
@Service("financeproductsExtractService")
public class FinanceproductsExtractServiceImpl implements FinanceproductsExtractService {

    @Autowired
    FinanceproductsExtractDao financeproductsExtractDao;

    /***
     * 转出数据总数
     * @param param
     * @return
     */
    @Override
    public int getOutProductCount(Map<String, Object> param) {
        String times = param.get("time").toString();
        String[] strs = times.replace("[","").replace("]","").split(",");
        String startTime = strs[0];
        String endTime = strs[1];

        param.put("startTime",startTime);
        param.put("endTime",endTime);

        int count = financeproductsExtractDao.getOutProductCount(param);

        return count;
    }

    /***
     * 获取转出数据列表
     * @param param
     * @return
     */
    @Override
    public List<UserOutProductList> getOutProductList(Map<String, Object> param) {
        String times = param.get("time").toString();
        String[] strs = times.replace("[","").replace("]","").split(",");
        String startTime = strs[0];
        String endTime = strs[1];

        //获取页数
        Integer page = Integer.parseInt(param.get("current").toString());
        //每页显示多少记录数
        Integer size = Integer.parseInt(param.get("size").toString());
        //重新计算页数
        param.remove("current");

        param.put("current",(page - 1) * size);
        param.put("startTime",startTime);
        param.put("endTime",endTime);

//        List<UserOutProductList> userOutProductLists = financeproductsExtractDao.getOutProductList(param);
//        if (userOutProductLists.size() > 0 || StringUtil.isNotNull(userOutProductLists)) {
//            return userOutProductLists;
//        }
        return null;
    }
}
