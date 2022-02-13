package com.study.backside.bean;

import lombok.Data;

@Data
public class Homework {
    private int courseId;
    private int homeworkId;
    private String homeworkTitle;
    private String description;
    private String deadline;
    private int percentage;

    public Homework(int cId, int hId, String hTitle, String des, String ddl, int per){
        this.courseId = cId;
        this.homeworkId = hId;
        this.homeworkTitle = hTitle;
        this.description = des;
        this.deadline = ddl;
        this.percentage = per;
    }
}
