package com.study.backside.mapper;

import com.study.backside.response.Result;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkMapper {
    int uploadHomework(String number,int courseId,int homeworkId,String link,String grade);
}
