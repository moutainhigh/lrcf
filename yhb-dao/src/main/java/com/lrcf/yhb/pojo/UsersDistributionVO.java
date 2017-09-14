package com.lrcf.yhb.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/12.
 */
public class UsersDistributionVO  implements Serializable{

    private String province;//省份

    private Integer count;//每天各省数量

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "UsersDistributionVO{" +
                "province='" + province + '\'' +
                ", count=" + count +
                '}';
    }
}
