package com.study.backside.response;

public class HomeworkStuRes {
    private String name;
    private String link;

    public HomeworkStuRes(String na,String link){
        this.name = na;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setName(String name) {
        this.name = name;
    }
}
