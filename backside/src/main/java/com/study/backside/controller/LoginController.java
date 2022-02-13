package com.study.backside.controller;

import com.study.backside.response.LoginResult;
import com.study.backside.response.Result;
import com.study.backside.service.CourseService;
import com.study.backside.service.LoginService;
import com.study.backside.util.IdentityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

/**
 * @Author Carol9s
 * @Classname
 * @Date 2022/2/12 14:59
 */

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    private IdentityUtil identityUtil;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResult login(@RequestParam("number") String number, @RequestParam("password") String password) throws IOException {
        if(loginService.isLogin(number, password)){
            if(loginService.getIdentity(number) == identityUtil.STUDENT_IDENTITY){
                return LoginResult.successStudent();
            }
            else if(loginService.getIdentity(number) == identityUtil.TEACHER_IDENTITY){
                return LoginResult.successTeacher();
            }
        }
        return LoginResult.error();
    }
}
