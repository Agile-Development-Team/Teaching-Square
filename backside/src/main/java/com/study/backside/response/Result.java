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

    public Result(){
    };

    public static Result success() {
        Result result = new Result();
        result.setCode(Renum.SUCCESS.getCode());
        result.setMsg(Renum.SUCCESS.getMsg());
        result.setSuccess(Renum.SUCCESS.getSuccess());
        return result;
    }
    public static Result error() {
        Result result = new Result();
        result.setCode(Renum.ERROR.getCode());
        result.setMsg(Renum.ERROR.getMsg());
        result.setSuccess(Renum.ERROR.getSuccess());
        return result;
    }

}
