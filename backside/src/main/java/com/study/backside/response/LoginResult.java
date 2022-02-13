package com.study.backside.response;

/**
 * @Author Carol9s
 * @Classname
 * @Date 2022/2/13 20:09
 */
public class LoginResult {
    private int code;
    private boolean success;
    private String msg;
    private int identity;

    public static LoginResult successStudent() {
        LoginResult loginresult = new LoginResult();
        loginresult.setCode(LRenum.SUCCESS_STUDENT.getCode());
        loginresult.setMsg(LRenum.SUCCESS_STUDENT.getMsg());
        loginresult.setSuccess(LRenum.SUCCESS_STUDENT.getSuccess());
        loginresult.setIdentity(LRenum.SUCCESS_STUDENT.getIdentity());
        return loginresult;
    }
    public static LoginResult successTeacher() {
        LoginResult loginresult = new LoginResult();
        loginresult.setCode(LRenum.SUCCESS_TEACHER.getCode());
        loginresult.setMsg(LRenum.SUCCESS_TEACHER.getMsg());
        loginresult.setSuccess(LRenum.SUCCESS_TEACHER.getSuccess());
        loginresult.setIdentity(LRenum.SUCCESS_TEACHER.getIdentity());
        return loginresult;
    }
    public static LoginResult error() {
        LoginResult loginresult = new LoginResult();
        loginresult.setCode(LRenum.ERROR.getCode());
        loginresult.setMsg(LRenum.ERROR.getMsg());
        loginresult.setSuccess(LRenum.ERROR.getSuccess());
        loginresult.setIdentity(LRenum.ERROR.getIdentity());
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
