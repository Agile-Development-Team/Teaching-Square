package com.study.backside.mapper;

import com.study.backside.bean.Course;
import com.study.backside.bean.TestCourse;
import com.study.backside.response.CoursesRes;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface CourseMapper {
    List<Course> getAllCourses() throws DataAccessException;
    List<CoursesRes> getStudentCourses(String number) throws DataAccessException;
    List<Integer> getCourseIdByStudentId(String number) throws DataAccessException;
    Course getCourseById(int courseId) throws DataAccessException;
    Course getCourseByIdAndCode(int courseId,String courseCode) throws DataAccessException;
    int addStudentCourse(String number,int courseId) throws DataAccessException;



}
