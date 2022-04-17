package com.study.backside.response;

/**
 * @Author Carol9s
 * @Classname
 * @Date 2022/2/13 20:12
 */
public enum LRenum{
    SUCCESS_STUDENT(200,true,"成功",1),
    SUCCESS_TEACHER(200,true,"成功",2),
    ERROR(404,false,"数据出错",0);
    //ERROR_TEACHER(404,false,"数据出错",2);

    private final Integer code;
    private final Boolean success;
    private final String msg;
    private final int identity;


    LRenum(Integer code, Boolean success, String msg, Integer identity) {
        this.code = code;
        this.success = success;
        this.msg = msg;
        this.identity = identity;
    }

    public Integer getCode() {
        return code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    public int getIdentity() {
        return identity;
    }
}
