package com.iothings.service.impl;

import com.iothings.dao.CourseRepository;
import com.iothings.entity.CourseEntity;
import com.iothings.entity.CoursePublishEntity;
import com.iothings.enums.CourseKeywordTypeEnum;
import com.iothings.form.CourseForm;
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
    public List<CoursePublishEntity> findAll(Integer paseSize, Integer pageNo, String keywords, String keywordType, String industry, String verifyStatus, String styleId) {
        List<CoursePublishEntity> courseEntity = new ArrayList<CoursePublishEntity>();
        switch (CourseKeywordTypeEnum.getByType(keywordType)){
            case NAME:
                courseEntity = courseRepository.findCourseEntityPageBean(paseSize, pageNo, keywords, industry, verifyStatus, styleId);
                break;
            case ID:
                courseEntity = courseRepository.findCourseEntityPageBean(paseSize, pageNo, keywords, industry, verifyStatus, styleId);
                break;
            case USER:
                courseEntity = courseRepository.findCourseEntityPageBean(paseSize, pageNo, keywords, industry, verifyStatus, styleId);
                break;
            case ORGAN:
                courseEntity = courseRepository.findCourseEntityPageBean(paseSize, pageNo, keywords, industry, verifyStatus, styleId);
                break;
            default:
                courseEntity = courseRepository.findCourseEntityPageBean(paseSize, pageNo, keywords, industry, verifyStatus, styleId);
                break;

        }
        return courseEntity;
    }

    @Override
    public Integer findCourseAllNumbers() {
        return courseRepository.findCourseAllNumbers();
    }

    @Override
    public CourseEntity addCourse(CourseForm courseForm) {
        CoursePublishEntity courseEntity = new CoursePublishEntity();
        courseEntity.setTitle(courseForm.getTilte());
        courseEntity.setSubTitle(courseForm.getSubTitle());
        courseEntity.setFrameId(Long.parseLong(courseForm.getStyleId()));
        courseEntity.setTitlePageUrls(courseForm.getImages());
        courseEntity.setSummary(courseForm.getContent());
        courseEntity.setIndustry(Long.parseLong(courseForm.getIndustry()));
        return courseRepository.save(courseEntity);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public CourseEntity verifyCourse(CourseForm courseForm) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(Long.parseLong(courseForm.getCourseId()));
        return null;
    }

}
