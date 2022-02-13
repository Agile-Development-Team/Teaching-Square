package com.study.backside.mapper;

import com.study.backside.bean.Homework;
import com.study.backside.bean.User;
import com.study.backside.response.Result;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeworkMapper {
    int uploadHomework(String number,int courseId,int homeworkId,String link,String grade);
    List<Homework> getHomeworksByCourseId(int courseId);
    String getLinkByNumberAndCourseIdAndHomeworkId(String number, int courseId, int homeworkId);
    Double getScoreByNumberAndCourseIdAndHomeworkId(String number, int courseId, int homeworkId);
}
