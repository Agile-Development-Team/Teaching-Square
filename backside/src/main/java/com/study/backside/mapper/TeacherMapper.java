package com.study.backside.mapper;

import com.study.backside.bean.Teacher;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface TeacherMapper {
    int addTeacher(String number, String name, String college, String e_mail, String tel) throws DataAccessException;
    Teacher getTeacherByCourseId(int courseId) throws DataAccessException;
    String getNameByNumber(String number) throws DataAccessException;
}
