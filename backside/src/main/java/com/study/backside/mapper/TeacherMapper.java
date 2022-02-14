package com.study.backside.mapper;

import com.study.backside.bean.Teacher;

import java.util.List;

public interface TeacherMapper {
    int addTeacher(String number, String name, String college, String e_mail, String tel);
    Teacher getTeacherByCourseId(int courseId);
}
