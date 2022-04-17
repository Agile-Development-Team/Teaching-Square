package com.study.backside.request;

import org.springframework.web.multipart.MultipartFile;

public class UpResourceRe {
    private int courseId;
    private String title;
    private MultipartFile file;
    public UpResourceRe(int id,String title,MultipartFile fi){
        this.courseId = id;
        this.title = title;
        this.file = fi;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
