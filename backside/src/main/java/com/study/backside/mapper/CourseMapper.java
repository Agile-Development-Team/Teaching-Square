package com.study.backside.mapper;

import com.study.backside.bean.TestCourse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    List<TestCourse> getAllCourses();


}
