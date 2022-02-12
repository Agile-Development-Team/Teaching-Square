package com.study.backside.mapper;

import com.study.backside.bean.Course;
import com.study.backside.bean.TestCourse;
import com.study.backside.response.CoursesRes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    List<Course> getAllCourses();
    List<CoursesRes> getStudentCourses(String number);
    List<Integer> getCourseIdByStudentId(String number);
    Course getCourseById(int courseId);
    Course getCourseByIdAndCode(int courseId,String courseCode);
    int addStudentCourse(String number,int courseId);



}
