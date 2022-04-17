package com.study.backside.bean;

import lombok.Data;


public class Course {
    private int courseId;
    private String courseName;
    private String code;


    public Course(String name,String code){
        this.courseName = name;
        this.code = code;
    }
    public Course(int id,String name,String code){
        this.courseId = id;
        this.courseName = name;
        this.code = code;

    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCode() {
        return code;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
