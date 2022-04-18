package com.study.backside.response;

/**
 * @Author Carol9s
 * @Classname
 * @Date 2022/4/18 20:55
 */
public class HomeworkTeacherRes {
    private int homeworkId;
    private String homeworkTitle;
    private String deadline;

    public HomeworkTeacherRes(int homeworkId, String homeworkTitle, String deadline) {
        this.homeworkId = homeworkId;
        this.homeworkTitle = homeworkTitle;
        this.deadline = deadline;
    }

    public int getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getHomeworkTitle() {
        return homeworkTitle;
    }

    public void setHomeworkTitle(String homeworkTitle) {
        this.homeworkTitle = homeworkTitle;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
