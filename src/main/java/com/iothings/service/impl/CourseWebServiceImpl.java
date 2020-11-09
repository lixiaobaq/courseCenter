package com.iothings.service.impl;

import com.iothings.dao.CourseRepository;
import com.iothings.dao.CourseWebRepository;
import com.iothings.entity.CourseCommentEntity;
import com.iothings.entity.CourseEntity;
import com.iothings.entity.CoursePublishEntity;
import com.iothings.form.CourseForm;
import com.iothings.service.CourseWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 前端课程实现接口Impl控制层
 *
 * @author Guoyan
 */
@Service
public class CourseWebServiceImpl implements CourseWebService {

    @Autowired
    private CourseWebRepository courseWebRepository;

    /**
     * 新增课程评论service层
     *
     * @param courseForm
     * @return
     */
    @Override
    public CourseCommentEntity addCurriculumEvaluation(CourseForm courseForm) {
        CourseCommentEntity courseComment = new CourseCommentEntity();
        courseComment.setCourseId(Long.parseLong(courseForm.getCourseId()));
        courseComment.setScore(Long.parseLong(courseForm.getScore()));
        courseComment.setEvaluate(courseForm.getEvaluate());
        return courseWebRepository.save(courseComment);
    }

    /**
     * 创建者id获取课程列表
     *
     * @param paseSize
     * @param pageNo
     * @param createrId
     * @return
     */
    @Override
    public List<CourseEntity> findCourseAllByCreaterId(Integer paseSize, Integer pageNo, Long createrId) {
        return courseWebRepository.findCourseAllByCreaterId(paseSize, pageNo, createrId);
    }

    /**
     * 创建者id获取课程列表总数
     *
     * @param createrId
     * @return
     */
    @Override
    public Integer findCourseAllNumbersByCreaterId(Long createrId) {
        return courseWebRepository.findCourseAllNumbersByCreaterId(createrId);
    }

    @Override
    public List<CoursePublishEntity> findRecommendedCoursesAll(CourseForm courseForm) {
        return courseWebRepository.findRecommendedCoursesAll(courseForm.getPageSize(), courseForm.getPageOn(), courseForm.getDirection(), courseForm.getCourseSort(), courseForm.getCourseType(), courseForm.getType());
    }

    @Override
    public Integer findRecommendedCoursesAllNumbers(CourseForm courseForm) {
        return courseWebRepository.findRecommendedCoursesAllNumbers(courseForm.getDirection(), courseForm.getCourseSort(), courseForm.getCourseType(), courseForm.getType());
    }
}
