package com.study.backside.response;

/**
 * @Author Carol9s
 * @Classname
 * @Date 2022/2/13 21:04
 */
public class HomeworkRes {
    private int courseId;
    private int homeworkId;
    private String homeworkTitle;
    private String description;
    private String deadline;
    private int percentage;

    public HomeworkRes(int cId, int hId, String hTitle, String des, String ddl, int per){
        this.courseId = cId;
        this.homeworkId = hId;
        this.homeworkTitle = hTitle;
        this.description = des;
        this.deadline = ddl;
        this.percentage = per;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getHomeworkId() {
        return homeworkId;
    }

    public String getHomeworkTitle() {
        return homeworkTitle;
    }

    public String getDescription() {
        return description;
    }

    public String getDeadline() {
        return deadline;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }

    public void setHomeworkTitle(String homeworkTitle) {
        this.homeworkTitle = homeworkTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
