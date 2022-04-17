package com.study.backside.request;

import org.springframework.web.multipart.MultipartFile;

public class UpHomeworkRe {
    private MultipartFile file;
    private String number;
    private int courseId;
    private int homeworkId;
    public UpHomeworkRe(MultipartFile fi, String number, int courseId, int homeworkId){
        this.file = fi;
        this.number = number;
        this.courseId = courseId;
        this.homeworkId = homeworkId;
    }

    public MultipartFile getFile() {
        return file;
    }

    public String getNumber() {
        return number;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getHomeworkId() {
        return homeworkId;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }
}

