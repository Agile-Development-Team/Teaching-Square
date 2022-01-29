package com.study.backside.bean;

public class TestCourse {
    private int course_id;
    private String course_name;
    private String content_id;
    private int teacher_id;

    public TestCourse(String courseName,String contentId,int teacherId){
        this.course_name = courseName;
        this.content_id = contentId;
        this.teacher_id = teacherId;
    }
    public TestCourse(int courseId,String courseName,String contentId,int teacherId){
        this.course_id = courseId;
        this.course_name = courseName;
        this.content_id = contentId;
        this.teacher_id = teacherId;
    }


    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getContent_id() {
        return content_id;
    }

    public void setContent_id(String content_id) {
        this.content_id = content_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }


}
