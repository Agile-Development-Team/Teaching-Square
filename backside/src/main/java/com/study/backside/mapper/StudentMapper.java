package com.study.backside.mapper;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * @Author Carol9s
 * @Classname
 * @Date 2022/2/13 23:47
 */
@Repository
public interface StudentMapper {
    int addStudent(String number, String name, String college, String major, String email, String tel) throws DataAccessException;
    String getNameByNumber(String number) throws DataAccessException;
}
