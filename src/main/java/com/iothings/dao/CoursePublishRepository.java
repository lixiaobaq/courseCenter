package com.iothings.dao;

import com.iothings.entity.CoursePublishEntity;
import com.iothings.entity.UserCertificationEntity;
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
public interface CoursePublishRepository extends JpaRepository<CoursePublishEntity, Long> {

    Page<CoursePublishEntity> findAll(Specification<CoursePublishEntity> specification, Pageable pageable);

}
