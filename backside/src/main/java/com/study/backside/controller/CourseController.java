package com.study.backside.controller;

import com.study.backside.bean.Course;
import com.study.backside.bean.Homework;
import com.study.backside.request.AddCourseRe;
import com.study.backside.request.ChooseCourseRe;
import com.study.backside.response.*;
import com.study.backside.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    private Logger log = LoggerFactory.getLogger("CourseController");


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public @ResponseBody
    Object allCourses(){
        try {
            return courseService.getAllCourses();
        }catch (DataAccessException e){
            log.error("/course error");
        }
        return new Result(500,false,"访问数据库失败");

    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/studentCourses", method = RequestMethod.GET)
    public @ResponseBody
    List<CoursesRes> getStudentCourses(@RequestParam(value = "number") String number) {
        try {
            return courseService.getStudentCourses(number);
        }catch (DataAccessException e){
            log.error("/studentCourses error");
        }
        return null;

    }

    //学生选课
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/chooseCourse", method = RequestMethod.POST)
    public @ResponseBody
    Result chooseCourse(@RequestBody ChooseCourseRe re){
        try {
            return courseService.chooseCourse(re.getNumber(), re.getCourseId(), re.getCourseCode());
        }catch (DataAccessException e){
            log.error("/chooseCourse error");
        }
        return new Result(500,false,"访问数据库失败");
    }


    //获取课程资源
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/courseResources", method = RequestMethod.GET)
    public @ResponseBody
    List<ResourceRes> getCourseResources(@RequestParam(value = "courseId") int courseId){
        try {
            return courseService.getCourseResources(courseId);
        }catch (DataAccessException e){
            log.error("/courseResources error");
        }
        return null;
    }

    /**
     * 查看学生上交的作业
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/searchHomeworkStudents", method = RequestMethod.GET)
    public @ResponseBody
    List<HomeworkStuRes> getHomeworkStudents(@RequestParam(value = "courseId") int courseId,
                                             @RequestParam(value = "homeworkId") int homeworkId){
        try {
            return courseService.getStudentsOfOneHomework(courseId, homeworkId);
        }catch (DataAccessException e){
            log.error("/searchHomeworkStudents error");
        }
        return null;
    }


    //教师发布课程
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public @ResponseBody
    Result addCourse(@RequestBody AddCourseRe re){
        try {
            courseService.addCourse(new Course(re.getCourseName(),re.getCourseCode()));
            //System.out.println("courseId "+courseId);
            return courseService.addTeacherCourse(re.getNumber());
        }catch (DataAccessException e){
            log.error("/addCourse error");
            log.error(e.getMessage());
        }
        return new Result(500,false,"访问数据库失败");
    }

    //教师发布作业
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/addHomework", method = RequestMethod.POST)
    public @ResponseBody
    Result addHomework(@RequestBody Homework hw){
        try {
            return courseService.addHomework(hw);
        }catch (DataAccessException e){
            log.error("/addHomework error");
            e.printStackTrace();
        }
        return new Result(500,false,"访问数据库失败");
    }


    /**
     * 查看教师发布的课程
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/teacherCourses", method = RequestMethod.GET)
    public @ResponseBody
    List<TeacherCourseRes> getTeacherCourses(@RequestParam(value = "number") String number){
        try {
            return courseService.getTeacherCourses(number);
        }catch (DataAccessException e){
            log.error("/searchHomeworkStudents error");
            log.error(e.getMessage());
        }
        return null;
    }









    /**
     * 返回课程作业列表
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/courseHomeworks", method = RequestMethod.GET)
    public List<HomeworkRes> getStudentHomeworks(@RequestParam(value = "number") String number,
                                                 @RequestParam(value = "courseId") int courseId){
        try{
            return courseService.getAllHomeworks(number, courseId);
        } catch (DataAccessException e) {
            log.error("/courseHomeworks error");
        }
        return null;
    }

    /**
     * 返回作业具体信息
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/homeworkDetail", method = RequestMethod.GET)
    public HomeworkDetailRes getHomeworkDetail(@RequestParam(value = "number") String number,
                                                 @RequestParam(value = "courseId") int courseId,
                                                 @RequestParam(value = "homeworkId") int homeworkId){
        try {
            return courseService.getHomeworkDetails(number, courseId, homeworkId);
        } catch (Exception e) {
            log.error("/homeworkDetail error");
        }
        return null;
    }
}
