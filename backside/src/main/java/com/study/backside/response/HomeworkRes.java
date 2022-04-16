package com.study.backside.response;

/**
 * @Author Carol9s
 * @Classname
 * @Date 2022/2/13 21:04
 */
public class HomeworkRes {
    private int homeworkId;
    private String homeworkTitle;
    private String deadline;
    private double score;

    public HomeworkRes(int hId, String hTitle, String ddl, double sc){
        this.homeworkId = hId;
        this.homeworkTitle = hTitle;
        this.deadline = ddl;
        this.score = sc;
    }

    public int getHomeworkId() {
        return homeworkId;
    }

    public String getHomeworkTitle() {
        return homeworkTitle;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }

    public void setHomeworkTitle(String homeworkTitle) {
        this.homeworkTitle = homeworkTitle;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public double getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
