package com.study.backside.request;

public class ScoreRe {
    private int courseId;
    private int homeworkId;
    private String number;
    private String link;
    private double grade;

    public ScoreRe(){}
    public ScoreRe(int cId,int hId,String num,double grade){
        this.courseId = cId;
        this.homeworkId = hId;
        this.number = num;
        this.grade = grade;
    }


    public int getCourseId() {
        return courseId;
    }

    public int getHomeworkId() {
        return homeworkId;
    }

    public String getNumber() {
        return number;
    }

    public String getLink() {
        return link;
    }

    public double getGrade() {
        return grade;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
