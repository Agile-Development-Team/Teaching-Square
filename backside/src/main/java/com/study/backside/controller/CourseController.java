package com.study.backside.controller;

import com.study.backside.response.CoursesRes;
import com.study.backside.response.HomeworkRes;
import com.study.backside.response.Result;
import com.study.backside.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public @ResponseBody
    Object allCourses() throws IOException {
        return courseService.getAllCourses();

    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/studentCourses", method = RequestMethod.GET)
    public @ResponseBody
    List<CoursesRes> getStudentCourses(@RequestParam(value = "number") String number) throws IOException {
        return courseService.getStudentCourses(number);

    }

    //学生选课
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/chooseCourse", method = RequestMethod.POST)
    public @ResponseBody
    Result chooseCourse(@RequestParam(value = "number") String number,
                        @RequestParam(value = "courseId") int courseId,
                        @RequestParam(value = "courseCode") String courseCode){
        return courseService.chooseCourse(number,courseId,courseCode);

    }

    /**
     * 课程作业列表
     */
    /*@CrossOrigin(origins = "*")
    @RequestMapping(value = "/courseHomeworks", method = RequestMethod.GET)
    public List<HomeworkRes> getStudentHomeworks(@RequestParam(value = "number") String number,
                                                 @RequestParam(value = "courseId") int courseId){
        return courseService.getAllHomeworks(number, courseId);
    }*/

}
