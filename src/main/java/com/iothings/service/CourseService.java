package com.iothings.service;

import com.iothings.VO.KeywordVO;
import com.iothings.entity.CourseEntity;
import com.iothings.entity.CourseFrame;
import com.iothings.entity.CoursePublishEntity;
import com.iothings.entity.ResourceEntity;
import com.iothings.exception.UnsupportedFileTypeException;
import com.iothings.form.CourseForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.PropertyException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Guoyan
 */
public interface CourseService {

    Page<CoursePublishEntity> findCourseAll(Pageable pageable, KeywordVO keywordVO);

    CourseEntity addCourse(CourseForm courseForm);

    boolean delete(Long id);

    CoursePublishEntity verifyCourse(CourseForm courseForm);

    boolean batchDelete(String ids);

    CoursePublishEntity saveCoursePublishById(Long id);

    String uploadImg(File file) throws UnsupportedFileTypeException, IOException, PropertyException;

    CoursePublishEntity findCoursePublishEntityById(Long id);

    CourseEntity updateCourse(CourseForm courseForm);

    ResourceEntity updateResourceEntity(CourseForm courseForm);
}
