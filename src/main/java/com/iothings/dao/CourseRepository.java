package com.iothings.dao;

import com.iothings.entity.CourseEntity;
import com.iothings.entity.CoursePublishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author: Huanglei
 * @time:2020/10/28 10:18 AM
 * @Description：
 */
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {


}
