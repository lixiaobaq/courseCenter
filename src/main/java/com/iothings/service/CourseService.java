package com.iothings.service;

import com.iothings.entity.CourseEntity;
import com.iothings.entity.CourseFrame;
import com.iothings.entity.CoursePublishEntity;
import com.iothings.form.CourseForm;

import java.util.List;

/**
 * @author Guoyan
 */
public interface CourseService {

    List<CoursePublishEntity> findAll(Integer paseSize, Integer pageNo, String keywords, String keywordType, String industry, String verifyStatus, String styleId);

    Integer findCourseAllNumbers();

    CourseEntity addCourse(CourseForm courseForm);

    void delete(Long id);

    CourseEntity verifyCourse(CourseForm courseForm);
}
