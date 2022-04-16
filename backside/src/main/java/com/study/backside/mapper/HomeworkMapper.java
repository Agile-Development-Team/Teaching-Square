package com.study.backside.mapper;

import com.study.backside.bean.Homework;
import com.study.backside.bean.StudentHomework;
import com.study.backside.bean.User;
import com.study.backside.response.Result;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface HomeworkMapper {
    int uploadHomework(String number,int courseId,int homeworkId,String link,String grade) throws DataAccessException;
    void updateHomework(String number,int courseId,int homeworkId,String link,String grade) throws DataAccessException;
    List<Integer> getStudentHomeworkById(String number,int courseId,int homeworkId)throws DataAccessException;
    List<Homework> getHomeworksByCourseId(int courseId) throws DataAccessException;
    String getLinkByNumberAndCourseIdAndHomeworkId(String number, int courseId, int homeworkId) throws DataAccessException;
    Double getScoreByNumberAndCourseIdAndHomeworkId(String number, int courseId, int homeworkId) throws DataAccessException;
    List<StudentHomework> getStudentsOfHomework(int courseId,int homeworkId) throws DataAccessException;
    int addHomework(Homework hw) throws DataAccessException;
    int getMaxHomeworkCount(int courseId) throws DataAccessException;

}
