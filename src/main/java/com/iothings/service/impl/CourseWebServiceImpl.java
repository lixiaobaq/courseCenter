package com.iothings.service.impl;

import com.iothings.VO.KeywordVO;
import com.iothings.dao.*;
import com.iothings.entity.*;
import com.iothings.form.CourseForm;
import com.iothings.service.CourseWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 前端课程实现接口Impl控制层
 *
 * @author Guoyan
 */
@Service
public class CourseWebServiceImpl implements CourseWebService {

    @Autowired
    private CourseCommentRepository courseCommentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CoursePublishRepository coursePublishRepository;

    @Autowired
    private CourseCatalogRepository courseCatalogRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ResourcePublishRepository resourcePublishRepository;

    /**
     * 新增课程评论service层
     *
     * @param courseForm
     * @return
     */
    @Override
    public CourseCommentEntity addCurriculumEvaluation(CourseForm courseForm) {
        CourseCommentEntity courseComment = new CourseCommentEntity();
        courseComment.setCourseId(Long.parseLong(courseForm.getId()));
        courseComment.setScore(Long.parseLong(courseForm.getScore()));
        courseComment.setEvaluate(courseForm.getEvaluate());
        return courseCommentRepository.save(courseComment);
    }

    /**
     * 创建者id获取课程列表
     * @param pageable
     * @param createrId
     * @return
     */
    @Override
    public Page<CourseEntity> findCourseAllByCreaterId(Pageable pageable, Long createrId) {
        Page<CourseEntity> page = courseRepository.findAll((Root<CourseEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            predicates.add(cb.equal(root.get("creater_id").as(Long.class), createrId));
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        }, pageable);
        return page;
    }

    @Override
    public Page<CoursePublishEntity> findRecommendedCoursesAll(Pageable pageable, KeywordVO keywordVO) {
        Page<CoursePublishEntity> page = coursePublishRepository.findAll((Root<CoursePublishEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            if (null != keywordVO.getDirection() && !"".equals(keywordVO.getDirection())) {
                predicates.add(cb.equal(root.get("direction").as(Long.class), keywordVO.getDirection()));
            }
            if (null != keywordVO.getCourseSort() && !"".equals(keywordVO.getCourseSort())) {
                predicates.add(cb.like(root.get("frameId").as(String.class), "%" + keywordVO.getCourseSort() + "%"));
            }
            if (null != keywordVO.getCourseType() && !"".equals(keywordVO.getCourseType())) {//少一个课程类型
                predicates.add(cb.equal(root.get("fee").as(Long.class), keywordVO.getCourseType()));
            }
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        }, pageable);
        return page;
    }

    @Override
    public List<CourseCatalogEntity> findCourseCatalogAll(Long id) {
        List<CourseCatalogEntity> courseCatalog = courseCatalogRepository.findAll();
        return courseCatalog;
    }

    @Override
    public ResourcePublishEntity findResourcePublishById(Long id) {
        return resourcePublishRepository.getOne(id);
    }
}
