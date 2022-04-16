package com.study.backside.bean;

import lombok.Data;

import java.util.Date;


public class Powerpoint {
    private int courseId;
    private int pptId;
    private String pptTitle;
    private String publishedTime;
    private String link;

    public Powerpoint(int cId,int pId,String title,String time,String link){
        this.courseId = cId;
        this.pptId = pId;
        this.pptTitle = title;
        this.publishedTime = time;
        this.link = link;
    }
    public Powerpoint(int cId,String title,String link){
        this.courseId = cId;
        this.pptTitle = title;
        this.link = link;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getLink() {
        return link;
    }

    public int getPptId() {
        return pptId;
    }

    public String getPptTitle() {
        return pptTitle;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setPptId(int pptId) {
        this.pptId = pptId;
    }

    public void setPptTitle(String pptTitle) {
        this.pptTitle = pptTitle;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }
}
