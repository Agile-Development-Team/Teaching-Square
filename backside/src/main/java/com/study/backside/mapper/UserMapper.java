package com.study.backside.mapper;

import com.study.backside.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Carol9s
 * @Classname
 * @Date 2022/2/12 16:40
 */

@Repository
public interface UserMapper {
    List<User> getAllUsers();
    String getPasswordByNumber(String number);
    int getIdentityByNumber(String number);
    int addUser(String number, String password, int identity);
}
