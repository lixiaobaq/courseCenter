package com.iothings.service.impl;

import com.iothings.dao.CourseRepository;
import com.iothings.entity.CourseEntity;
import com.iothings.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseEntity> findAll(Integer paseSize, Integer pageNo, String keywords, String keywordType, Integer industry, Integer verifyStatus) {
        List<CourseEntity> courseEntity = courseRepository.findCourseEntityPageBean(paseSize, pageNo);
        return courseEntity;
    }
}
