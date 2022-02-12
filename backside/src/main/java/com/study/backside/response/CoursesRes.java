package com.study.backside.response;

import lombok.Data;


public class CoursesRes {
    private int courseId;
    private String courseName;
    private String teacherName;

    public CoursesRes(int id, String courseName, String teacherName){
        this.courseId = id;
        this.courseName = courseName;
        this.teacherName = teacherName;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
