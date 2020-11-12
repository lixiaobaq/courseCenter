package com.iothings.dao;

import com.iothings.entity.CourseCatalogEntity;
import com.iothings.entity.CoursePublishEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Huanglei
 * @time:2020/10/28 10:18 AM
 * @Description：
 */
public interface CourseCatalogRepository extends JpaRepository<CourseCatalogEntity, Long> {

}
