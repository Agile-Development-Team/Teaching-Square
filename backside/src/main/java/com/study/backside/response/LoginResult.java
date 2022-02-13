package com.study.backside.response;

import lombok.Data;

/**
 * @Author Carol9s
 * @Classname
 * @Date 2022/2/13 20:09
 */
@Data
public class LoginResult {
    private int code;
    private boolean success;
    private String msg;
    private int identity;
    private Object data;

    public static LoginResult success(Object object) {
        LoginResult loginresult = new LoginResult();
        loginresult.setCode(LRenum.SUCCESS_STUDENT.getCode());
        loginresult.setMsg(LRenum.SUCCESS_STUDENT.getMsg());
        loginresult.setSuccess(LRenum.SUCCESS_STUDENT.getSuccess());
        loginresult.setData(object);
        return loginresult;
    }
    public static LoginResult error(Object object) {
        LoginResult loginresult = new LoginResult();
        loginresult.setCode(LRenum.ERROR.getCode());
        loginresult.setMsg(LRenum.ERROR.getMsg());
        loginresult.setSuccess(LRenum.ERROR.getSuccess());
        loginresult.setData(object);
        return loginresult;
    }
    /*
    public static LoginResult errorStudent() {
        LoginResult loginresult = new LoginResult();
        loginresult.setCode(LRenum.ERROR_STUDENT.getCode());
        loginresult.setMsg(LRenum.ERROR_STUDENT.getMsg());
        loginresult.setSuccess(LRenum.ERROR_STUDENT.getSuccess());
        loginresult.setIdentity(LRenum.ERROR_STUDENT.getIdentity());
        return loginresult;
    }
    public static LoginResult errorTeacher() {
        LoginResult loginresult = new LoginResult();
        loginresult.setCode(LRenum.ERROR_TEACHER.getCode());
        loginresult.setMsg(LRenum.ERROR_TEACHER.getMsg());
        loginresult.setSuccess(LRenum.ERROR_TEACHER.getSuccess());
        loginresult.setIdentity(LRenum.ERROR_TEACHER.getIdentity());
        return loginresult;
    }
    */


    public void setCode(int code) {
        this.code = code;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }
}
