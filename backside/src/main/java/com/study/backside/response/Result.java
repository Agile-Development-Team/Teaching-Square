package com.study.backside.response;

import lombok.Data;

@Data
public class Result {
    private int code;
    private boolean success;
    private String msg;
    public Result(int code,boolean suc,String msg){
        this.code = code;
        this.success = suc;
        this.msg = msg;
    }
}
