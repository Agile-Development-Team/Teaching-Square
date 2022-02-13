package com.study.backside.service;

import com.study.backside.bean.Course;
import com.study.backside.bean.Homework;
import com.study.backside.bean.Teacher;
import com.study.backside.bean.TestCourse;
import com.study.backside.mapper.CourseMapper;
import com.study.backside.mapper.HomeworkMapper;
import com.study.backside.mapper.TeacherMapper;
import com.study.backside.response.CoursesRes;
import com.study.backside.response.HomeworkRes;
import com.study.backside.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    //将mapper注入service
    @Resource
    private CourseMapper courseMapper;
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private HomeworkMapper homeworkMapper;

    private Logger log = LoggerFactory.getLogger("CourseService");

    public List<CoursesRes> getAllCourses(){
        List<Course> courses = courseMapper.getAllCourses();
        List<CoursesRes> res = new ArrayList<>();
        for(Course co:courses){
            Teacher tea = teacherMapper.getTeacherByCourseId(co.getCourseId());
            System.out.println("tea "+ tea);
            res.add(new CoursesRes(co.getCourseId(),co.getCourseName(),tea.getName()));
        }
        return res;
    }

    public List<CoursesRes> getStudentCourses(String number) {
          List<Integer> courseIds = courseMapper.getCourseIdByStudentId(number);
          List<CoursesRes> res = new ArrayList<>();
        for(int courseId:courseIds){
            Course co =courseMapper.getCourseById(courseId);
            Teacher tea = teacherMapper.getTeacherByCourseId(courseId);
            res.add(new CoursesRes(courseId,co.getCourseName(),tea.getName()));

        }
        return res;
    }

    public Result chooseCourse(String number,int courseId, String courseCode){
        Course co = courseMapper.getCourseByIdAndCode(courseId,courseCode);
        if(co==null){
            return new Result(400,false,"选课失败");
        }
        int i=0;
        try{
            i = courseMapper.addStudentCourse(number,courseId);
        }catch (Exception e){
            log.error("add student_course error");
        }
        return i==1?new Result(200,true,"选课成功"):new Result(400,false,"选课失败");


    }

    public List<HomeworkRes> getAllHomeworks(int courseId) throws IOException {

    }
}
