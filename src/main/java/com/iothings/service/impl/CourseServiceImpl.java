package com.iothings.service.impl;

//import com.iothings.service.CourseService;

import com.iothings.dao.CourseRepository;
import com.iothings.entity.CourseEntity;
import com.iothings.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CourseEntity findCourseById(Long courseId) {
        return courseRepository.getOne(courseId);
    }

    @Override
    public List<CourseEntity> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCouses(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
