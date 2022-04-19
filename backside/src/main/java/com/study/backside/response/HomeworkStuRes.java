package com.study.backside.response;

public class HomeworkStuRes {
    private String number;
    private String name;
    private String link;

    public HomeworkStuRes(String num,String na,String link){
        this.number = num;
        this.name = na;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setName(String name) {
        this.name = name;
    }
}
