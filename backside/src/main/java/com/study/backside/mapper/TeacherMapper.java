package com.study.backside.mapper;

import com.study.backside.bean.Teacher;

import java.util.List;

public interface TeacherMapper {
    Teacher getTeacherByCourseId(int courseId);
}
