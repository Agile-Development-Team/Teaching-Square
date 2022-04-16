package com.study.backside.request;

public class AddCourseRe {
    private String number;
    private String courseName;
    private String courseCode;

    public AddCourseRe(String num,String name,String code){
        this.number = num;
        this.courseName = name;
        this.courseCode = code;
    }

    public String getNumber() {
        return number;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
