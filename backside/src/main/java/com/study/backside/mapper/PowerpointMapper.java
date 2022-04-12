package com.study.backside.mapper;

import com.study.backside.bean.Powerpoint;
import org.springframework.dao.DataAccessException;


import java.sql.SQLException;
import java.util.List;

public interface PowerpointMapper {
    List<Powerpoint> getCourseResources(int courseId) throws DataAccessException;

}
