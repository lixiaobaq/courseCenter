package com.iothings.service;

import com.iothings.entity.CoursePublishEntity;

import java.util.List;

/**
 * @author Guoyan
 */
public interface CourseService {

    List<CoursePublishEntity> findAll(Integer paseSize, Integer pageNo, String keywords, String keywordType, Integer industry, Integer verifyStatus);

    Integer findCourseAllNumbers();
}
