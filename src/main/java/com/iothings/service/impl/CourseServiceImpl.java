package com.iothings.service.impl;

import com.iothings.dao.CourseRepository;
import com.iothings.entity.CourseEntity;
import com.iothings.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseEntity> findAll(Integer paseSize, Integer pageNo) {
        List<CourseEntity> courseEntity = courseRepository.findCourseEntityPageBean(paseSize, pageNo);
        return courseEntity;
    }
}
