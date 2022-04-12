package com.study.backside.controller;

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




    /**
     * 返回课程作业列表
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/courseHomeworks", method = RequestMethod.GET)
    public List<HomeworkRes> getStudentHomeworks(@RequestParam(value = "number") String number,
                                                 @RequestParam(value = "courseId") int courseId){
        return courseService.getAllHomeworks(number, courseId);
    }

}
