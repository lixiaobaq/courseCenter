package com.iothings.service.impl;

import com.iothings.dao.CoursePublishRepository;
import com.iothings.dao.CourseRepository;
import com.iothings.entity.CourseEntity;
import com.iothings.entity.CoursePublishEntity;
import com.iothings.enums.CoursePublishEnum;
import com.iothings.form.CourseForm;
import com.iothings.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CoursePublishRepository coursePublishRepository;
    @Override
    public List<CoursePublishEntity> findAll(Integer paseSize, Integer pageNo, String keywords, String keywordType, String industry, String verifyStatus, String styleId) {
        Pageable pageable = new PageRequest(pageNo, paseSize);
        List<CoursePublishEntity> courseEntity = coursePublishRepository.findCourseEntityPageBean(paseSize, pageNo, keywords, keywordType, industry, verifyStatus, styleId);
        return courseEntity;
    }

    @Override
    public Integer findCourseAllNumbers() {
        return coursePublishRepository.findCourseAllNumbers();
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
        return coursePublishRepository.save(courseEntity);
    }

    @Override
    public void delete(Long id) {
        coursePublishRepository.deleteById(id);
    }

    @Override
    public CourseEntity verifyCourse(CourseForm courseForm) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(Long.parseLong(courseForm.getCourseId()));
        return null;
    }

    @Override
    public void batchDelete(String ids) {
        if(ids.contains(",")){
            String[] list = ids.split(",");
            for(String id:list){
                coursePublishRepository.deleteById(Long.parseLong(id));
            }
        }else{
            coursePublishRepository.deleteById(Long.parseLong(ids));
        }
    }

    @Override
    public void saveCoursePublishById(Long id) {
        CourseEntity courseEntity = courseRepository.getOne(id);
        CoursePublishEntity coursePublishEntity = new CoursePublishEntity();
        BeanUtils.copyProperties(coursePublishEntity, courseEntity);
        coursePublishEntity.setVersionNumber("1.0.1");
        coursePublishEntity.setSubmitterId(1l);
        coursePublishEntity.setStatus(CoursePublishEnum.NEW.getMessage());
        coursePublishRepository.save(coursePublishEntity);
    }

    @Override
    public String uploadImg(File file) {

        return null;
    }
}
