package com.study.backside.response;

/**
 * @Author Carol9s
 * @Classname
 * @Date 2022/4/18 21:07
 */
public class StudentHomeworkStateRes {
    private String studentName;
    private int finishedCount;
    private int totalCount;

    public StudentHomeworkStateRes(String name, int homeworkCount, int homeworkDeliverCount) {
        studentName = name;
        finishedCount = homeworkCount;
        totalCount = homeworkDeliverCount;
    }

    public String getName() {
        return studentName;
    }

    public void setName(String name) {
        this.studentName = name;
    }

    public int getFinishedCount() {
        return finishedCount;
    }

    public void setFinishedCount(int finishedCount) {
        this.finishedCount = finishedCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
