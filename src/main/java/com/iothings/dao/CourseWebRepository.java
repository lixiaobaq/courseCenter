package com.iothings.dao;

import com.iothings.entity.CourseCommentEntity;
import com.iothings.entity.CourseEntity;
import com.iothings.entity.CoursePublishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 前端课程DAO控制层
 * @author: Guoyan
 */
public interface CourseWebRepository extends JpaRepository<CourseCommentEntity, Long> {

    /**
     * 创建者id查询课程列表
     * @param page
     * @param pageNo
     * @param createrId
     * @return
     */
    @Query(value = "SELECT * FROM course WHERE creater_id = ?3 ORDER BY create_time DESC LIMIT ?2,?1", nativeQuery = true)
    List<CourseEntity> findCourseAllByCreaterId(Integer page, Integer pageNo, Long createrId);

    /**
     * 创建者id查询课程总数列表
     * @param createrId
     * @return
     */
    @Query(value = "SELECT COUNT(*) FROM course WHERE creater_id = ?1", nativeQuery = true)
    Integer findCourseAllNumbersByCreaterId(Long createrId);

    @Query(value = "SELECT * FROM course_publish cp LEFT JOIN course c ON c.id = cp.course_id WHERE c.industry = ?3 AND CONCAT(c.frame_id) LIKE %?4% AND cp.type = ?6 ORDER BY cp.create_time LIMIT ?2,?1", nativeQuery = true)
    List<CoursePublishEntity> findRecommendedCoursesAll(Integer page, Integer pageNo, String direction, String courseSort, String courseType, String type);

    @Query(value = "SELECT * FROM course_publish cp LEFT JOIN course c ON c.id = cp.course_id WHERE c.industry = ?1 AND CONCAT(c.frame_id) LIKE %?2% AND cp.type = ?4", nativeQuery = true)
    Integer findRecommendedCoursesAllNumbers(String direction, String courseSort, String courseType, String type);
}
