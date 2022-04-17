package com.study.backside.bean;

import lombok.Data;


public class Homework {
    private int courseId;
    private int homeworkId;
    private String homeworkTitle;
    private String description;
    private String deadline;
    private int percentage;

    public Homework(){}

    public Homework(int cId, int hId, String hTitle, String des, String ddl, int per){
        this.courseId = cId;
        this.homeworkId = hId;
        this.homeworkTitle = hTitle;
        this.description = des;
        this.deadline = ddl;
        this.percentage = per;
    }
    public Homework(int cId, String hTitle, String des, String ddl, int per){
        this.courseId = cId;

        this.homeworkTitle = hTitle;
        this.description = des;
        this.deadline = ddl;
        this.percentage = per;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getHomeworkId() {
        return homeworkId;
    }

    public int getPercentage() {
        return percentage;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return description;
    }

    public String getHomeworkTitle() {
        return homeworkTitle;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setHomeworkTitle(String homeworkTitle) {
        this.homeworkTitle = homeworkTitle;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
