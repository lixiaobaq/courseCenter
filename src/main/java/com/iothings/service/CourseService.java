package com.iothings.service;

import com.iothings.entity.CourseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Guoyan
 */
public interface CourseService {

    List<CourseEntity> findAll(Integer paseSize, Integer pageNo, String keywords, String keywordType, Integer industry, Integer verifyStatus);

    Integer findCourseAllNumbers();
}
