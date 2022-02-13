package com.study.backside.service;

import com.study.backside.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author Carol9s
 * @Classname
 * @Date 2022/2/12 15:20
 */
public class LoginService {
    @Resource
    private UserMapper userMapper;

    private Logger log = LoggerFactory.getLogger("LoginService");

    public Boolean isLogin(String number, String password)throws IOException {
        String correctPassword = userMapper.getPasswordByNumber(number);
        if(correctPassword == password)
            return true;
        else
            return false;
    }

    public int getIdentity(String number)throws IOException{
        return userMapper.getIdentityByNumber(number);
    }
}
