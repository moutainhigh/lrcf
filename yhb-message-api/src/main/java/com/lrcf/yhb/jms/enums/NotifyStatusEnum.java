package com.lrcf.yhb.jms.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 消息状态
 * Created by Krx on 2017/6/27 0027.
 */
public enum NotifyStatusEnum {

    YES("是"),
    NO("否"),
    WAITING_CONFIRM("待确认"),
    SENDING("发送中"),
    DECEASED("已死亡");


    private String desc;

    NotifyStatusEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public static Map<String, Map<String, Object>> toMap() {
        NotifyStatusEnum[] ary = NotifyStatusEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
        for (int num = 0; num < ary.length; num++) {
            Map<String, Object> map = new HashMap<String, Object>();
            String key = ary[num].name();
            map.put("desc", ary[num].getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List toList() {
        NotifyStatusEnum[] ary = NotifyStatusEnum.values();
        List list = new ArrayList();
        for (int i = 0; i < ary.length; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("desc", ary[i].getDesc());
            list.add(map);
        }
        return list;
    }

    public static NotifyStatusEnum getEnum(String name) {
        NotifyStatusEnum[] arry = NotifyStatusEnum.values();
        for (int i = 0; i < arry.length; i++) {
            if (arry[i].name().equalsIgnoreCase(name)) {
                return arry[i];
            }
        }
        return null;
    }

    /**
     * 取枚举的json字符串
     *
     * @return
     */
    public static String getJsonStr() {
        NotifyStatusEnum[] enums = NotifyStatusEnum.values();
        StringBuffer jsonStr = new StringBuffer("[");
        for (NotifyStatusEnum senum : enums) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }
}

