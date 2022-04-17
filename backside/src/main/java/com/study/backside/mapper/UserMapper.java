package com.study.backside.mapper;

import com.study.backside.bean.User;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author Carol9s
 * @Classname
 * @Date 2022/2/12 16:40
 */

@Repository
public interface UserMapper {
    List<User> getAllUsers() throws DataAccessException;
    String getPasswordByNumber(String number) throws DataAccessException;
    int getIdentityByNumber(String number) throws DataAccessException;
    int addUser(String number, String password, int identity) throws DataAccessException;
}
