package com.iothings.service.impl;

import com.iothings.dao.CourseRepository;
import com.iothings.entity.CoursePublishEntity;
import com.iothings.enums.CourseKeywordTypeEnum;
import com.iothings.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CoursePublishEntity> findAll(Integer paseSize, Integer pageNo, String keywords, String keywordType, Integer industry, Integer verifyStatus) {
        List<CoursePublishEntity> courseEntity = new ArrayList<CoursePublishEntity>();
        switch (CourseKeywordTypeEnum.getByType(keywordType)){
            case NAME:
                courseEntity = courseRepository.findCourseEntityPageBean(paseSize, pageNo, keywords, industry, verifyStatus);
                break;
            case ID:
                courseEntity = courseRepository.findCourseEntityPageBean(paseSize, pageNo, keywords, industry, verifyStatus);
                break;
            case USER:
                courseEntity = courseRepository.findCourseEntityPageBean(paseSize, pageNo, keywords, industry, verifyStatus);
                break;
            case ORGAN:
                courseEntity = courseRepository.findCourseEntityPageBean(paseSize, pageNo, keywords, industry, verifyStatus);
                break;
            default:
                courseEntity = courseRepository.findCourseEntityPageBean(paseSize, pageNo, keywords, industry, verifyStatus);
                break;

        }
        return courseEntity;
    }

    @Override
    public Integer findCourseAllNumbers() {
        return courseRepository.findCourseAllNumbers();
    }
}
