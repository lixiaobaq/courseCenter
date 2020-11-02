package com.iothings.service;

import com.iothings.entity.CourseEntity;

import java.util.List;

/**
 * @author Guoyan
 */
public interface CourseService {

    CourseEntity findCourseById(Long courseId);

    List<CourseEntity> findAll();

    void deleteCouses(Long courseId);
}
