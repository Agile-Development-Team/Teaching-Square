package com.study.backside.bean;

import lombok.Data;

@Data
public class StudentHomework {
    private int courseId;
    private int homeworkId;
    private String number;
    private String link;
    private int grade;
}
