package com.study.backside.service;

import com.study.backside.bean.TestCourse;
import com.study.backside.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseService {

    //将mapper注入service
    @Resource
    private CourseMapper courseMapper;

    public List<TestCourse> getAllCourses(){
        return courseMapper.getAllCourses();
    }
}
