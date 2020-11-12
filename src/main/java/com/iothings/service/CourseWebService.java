package com.iothings.service;

import com.iothings.VO.KeywordVO;
import com.iothings.entity.*;
import com.iothings.form.CourseForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Guoyan
 */
public interface CourseWebService {

    CourseCommentEntity addCurriculumEvaluation(CourseForm courseForm);

    Page<CourseEntity> findCourseAllByCreaterId(Pageable pageable, Long createrId);

    Page<CoursePublishEntity> findRecommendedCoursesAll(Pageable pageable, KeywordVO keywordVO);

    List<CourseCatalogEntity> findCourseCatalogAll(Long id);

    ResourcePublishEntity findResourcePublishById(Long id);
}
