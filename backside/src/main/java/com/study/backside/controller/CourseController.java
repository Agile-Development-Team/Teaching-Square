package com.study.backside.controller;

import com.study.backside.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
}
