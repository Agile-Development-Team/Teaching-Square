package com.study.backside.controller;

import com.study.backside.util.Account;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.study.backside.response.LoginResult;
import com.study.backside.response.Result;
import com.study.backside.service.CourseService;
import com.study.backside.service.LoginService;
import com.study.backside.util.IdentityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * @Author Carol9s
 * @Classname
 * @Date 2022/2/12 14:59
 */

@RestController
public class LogInController {
        @Autowired
        private LoginService loginService;
        private IdentityUtil identityUtil;

        private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResult login(@RequestParam("number") String number, @RequestParam("password") String password) throws IOException {
        if (loginService.isLogin(number, password)) {
            if (loginService.getIdentity(number) == identityUtil.STUDENT_IDENTITY) {
                return LoginResult.successStudent();
            } else if (loginService.getIdentity(number) == identityUtil.TEACHER_IDENTITY) {
                return LoginResult.successTeacher();
            }
        }
        return LoginResult.error();
    }

    /**
     * 注册
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestParam("number") String number,
                           @RequestParam("password") String password,
                           @RequestParam("identity") int identity) throws IOException{
        loginService.addUser(number, password, identity);
        return Result.success();
    }

}
