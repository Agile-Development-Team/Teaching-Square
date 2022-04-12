package com.study.backside.response;

public class ResourceRes {

    private int pptId;
    private String title;
    private String publishedTime;
    private String link;

    public ResourceRes(int pId, String title, String pTime,String link){
        this.pptId = pId;
        this.title = title;
        this.publishedTime = pTime;
        this.link = link;

    }

    public String getTitle() {
        return title;
    }

    public String getPublishedTime() {
        return publishedTime;
    }



    public int getPptId() {
        return pptId;
    }



    public String getLink() {
        return link;
    }



    public void setPptId(int pptId) {
        this.pptId = pptId;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

