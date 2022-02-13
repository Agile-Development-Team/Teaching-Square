package com.study.backside.response;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @Author Carol9s
 * @Classname
 * @Date 2022/2/12 15:49
 */
public enum Renum {
    SUCCESS(200,true,"成功"),
    ERROR(404,false,"数据出错");

    private final Integer code;
    private final Boolean success;
    private final String msg;


    Renum(Integer code, Boolean success, String msg) {
        this.code = code;
        this.success = success;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Boolean getSuccess() { return success; }
}
