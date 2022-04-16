package com.study.backside.service;

import com.study.backside.bean.*;
import com.study.backside.mapper.*;
import com.study.backside.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
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
    private StudentMapper studentMapper;
    @Resource
    private PowerpointMapper powerpointMapper;
    @Resource
    private HomeworkMapper homeworkMapper;

    public Logger log = LoggerFactory.getLogger("CourseService");

    public List<CoursesRes> getAllCourses() throws DataAccessException {
        List<Course> courses = courseMapper.getAllCourses();
        List<CoursesRes> res = new ArrayList<>();
        for(Course co:courses){
            Teacher tea = teacherMapper.getTeacherByCourseId(co.getCourseId());
            System.out.println("tea "+ tea);
            res.add(new CoursesRes(co.getCourseId(),co.getCourseName(),tea.getName()));
        }
        return res;
    }

    public List<CoursesRes> getStudentCourses(String number) throws DataAccessException{
          List<Integer> courseIds = courseMapper.getCourseIdByStudentId(number);
          List<CoursesRes> res = new ArrayList<>();
        for(int courseId:courseIds){
            Course co =courseMapper.getCourseById(courseId);
            Teacher tea = teacherMapper.getTeacherByCourseId(courseId);
            res.add(new CoursesRes(courseId,co.getCourseName(),tea.getName()));

        }
        return res;
    }

    public Result chooseCourse(String number,int courseId, String courseCode) throws DataAccessException{
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

    public List<ResourceRes> getCourseResources(int courseId) throws DataAccessException{
        List<Powerpoint> resourceList = powerpointMapper.getCourseResources(courseId);
        List<ResourceRes> res = new ArrayList<>();
        for(Powerpoint re:resourceList){
            String time = new SimpleDateFormat("yyyy-MM-dd").format(re.getPublishedTime());
            res.add(new ResourceRes(re.getPptId(),re.getPptTitle(),time,re.getLink()));

        }
        return res;

    }

    public List<HomeworkStuRes> getStudentsOfOneHomework(int courseId,int homeworkId) throws DataAccessException{
        List<StudentHomework> list = homeworkMapper.getStudentsOfHomework(courseId,homeworkId);
        List<HomeworkStuRes> res = new ArrayList<>();
        try {
            for (StudentHomework sh : list) {
                res.add(new HomeworkStuRes(studentMapper.getNameByNumber(sh.getNumber()), URLEncoder.encode(sh.getLink(), "UTF-8")));
            }
            return res;
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return res;
    }

    public void addCourse(Course co) throws DataAccessException{
        courseMapper.addCourse(co);


    }

    public Result addTeacherCourse(String number) throws DataAccessException{
        int courseId = courseMapper.getMaxCourseId();
        int i = courseMapper.addTeacherCourse(number,courseId);
        if(i==1){
            return new Result(200,true,"发布课程成功");
        }
        return new Result(400,false,"发布课程失败");
    }

    public Result addHomework(Homework hw) throws DataAccessException{
        int homeworkId = homeworkMapper.getMaxHomeworkCount(hw.getCourseId())+1;
        hw.setHomeworkId(homeworkId);
        int i = homeworkMapper.addHomework(hw);
        if(i==1){
            return new Result(200,true,"发布作业成功");
        }
        return new Result(400,false,"发布作业失败");
    }

    public List<TeacherCourseRes> getTeacherCourses(String number) throws DataAccessException{
        String tName = teacherMapper.getTeacherNameByNumber(number);
        List<Course> cos = courseMapper.getCourseByTeacherNumber(number);
        List<TeacherCourseRes> res = new ArrayList<>();
        for(Course co:cos){
            res.add(new TeacherCourseRes(co.getCourseName(),co.getCourseId(),tName));
        }
        return res;


    }


}
