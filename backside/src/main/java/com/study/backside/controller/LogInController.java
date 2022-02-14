package com.study.backside.controller;

import org.springframework.web.bind.annotation.*;
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
    @CrossOrigin(origins = "*")
    //@PostMapping("/login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResult login(@RequestParam("number") String number, @RequestParam("password") String password) throws IOException {
        if (loginService.isLogin(number, password)) {
            int identity = loginService.getIdentity(number);
            return LoginResult.success(identity);
        }
        int identity = 0;
        return LoginResult.error(identity);
    }

    /**
     * 注册
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestParam("number") String number,
                           @RequestParam("password") String password,
                           @RequestParam("name") String name,
                           @RequestParam("college") String college,
                           @RequestParam("major") String major,
                           @RequestParam("email") String email,
                           @RequestParam("tel") String tel,
                           @RequestParam("identity") int identity) throws IOException{
        if(loginService.addUser(number, password, name, college, major, email, tel, identity))
            return Result.success();
        return Result.error();
    }

}