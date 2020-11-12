package com.iothings.dao;

import com.iothings.entity.CoursePublishEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author: Huanglei
 * @time:2020/10/28 10:18 AM
 * @Description：
 */
public interface CourseRepository extends JpaRepository<CoursePublishEntity,Long> {

    @Query(value = "SELECT * FROM course_publish cp LEFT JOIN course c ON c.id = cp.course_id WHERE CONCAT(c.title,c.sub_title) LIKE %?3% LIMIT ?2,?1", nativeQuery=true)
    List<CoursePublishEntity> findCourseEntityPageBean(Integer page, Integer pageNo, String keywords, Integer industry, Integer verifyStatus);

    @Query(value = "SELECT COUNT(*) FROM course_publish cp LEFT JOIN course c ON c.id = cp.course_id", nativeQuery=true)
    Integer findCourseAllNumbers();

    Page<CourseEntity> findAll(Specification<CourseEntity> specification, Pageable pageable);
    /**
     * 获取课程分类下的所有课程数量(勿删)
     * @param id
     * @return
     */
    @Query(value = "SELECT  COUNT(*) FROM `course` WHERE FIND_IN_SET( ?1, frame_id) ",nativeQuery = true)
    Integer findCourseNumByFrame(Integer id);
}
