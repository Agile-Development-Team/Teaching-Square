package com.study.backside.response;

public class TeacherCourseRes {
    private String courseName;
    private int courseId;
    private String teacherName;
    public TeacherCourseRes(String cName,int id,String tName){
        this.courseId = id;
        this.courseName = cName;
        this.teacherName = tName;
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
