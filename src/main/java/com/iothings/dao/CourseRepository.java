package com.iothings.dao;

import com.iothings.entity.CourseEntity;
import com.iothings.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author: Huanglei
 * @time:2020/10/28 10:18 AM
 * @Description：
 */
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {

    @Query(value = "SELECT * FROM course WHERE LIMIT ?1,?2", nativeQuery=true)
    List<CourseEntity> findCourseEntityPageBean(Integer page, Integer pageNo);

}
