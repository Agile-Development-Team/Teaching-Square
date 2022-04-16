package com.study.backside.response;

/**
 * @Author Carol9s
 * @Classname
 * @Date 2022/4/12 17:24
 */
public class HomeworkDetailRes {
    private String description;
    private String deadline;
    private String link;

    public HomeworkDetailRes(String description, String deadline, String link) {
        this.description = description;
        this.deadline = deadline;
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
