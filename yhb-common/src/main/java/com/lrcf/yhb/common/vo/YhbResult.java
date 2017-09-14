package com.lrcf.yhb.common.vo;


import java.io.Serializable;

/**
 * 自定义响应结构
 */
public class YhbResult implements Serializable {
    //响应状态码
    private Integer code;
    //响应信息
    private String message;
    //具体参数
    private Object result;

    public YhbResult(Integer code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public YhbResult() {

    }

    public YhbResult(Object result){
        this.message = "success";
        this.code = 200;
        this.result = result;
    }

    public YhbResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static YhbResult success(Object result) {
        return new YhbResult(result);
    }

    public static YhbResult build(Integer code,String message){
        return new YhbResult(code, message);}

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getresult() {
        return result;
    }

    public void setresult(Object result) {
        this.result = result;
    }
}
