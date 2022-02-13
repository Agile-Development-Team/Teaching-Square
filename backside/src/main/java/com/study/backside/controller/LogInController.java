package com.study.backside.controller;

import com.study.backside.util.Account;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Carol9s
 * @Classname LogInController
 * @Date 2022/1/23 19:11
 */

@RestController
public class LogInController {
    //测试
    @RequestMapping(value = "/test")
    public String test(){
        return "test success";
    }

    /**
     * 登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Account login(){
        Account account = new Account();
        //todo 登录
        return account;
    }

    /**
     * 注册
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Account register(){
        Account account = new Account();
        //todo 注册
        return account;
    }
}
