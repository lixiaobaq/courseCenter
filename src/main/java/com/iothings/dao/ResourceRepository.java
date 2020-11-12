package com.iothings.dao;

import com.iothings.entity.CourseEntity;
import com.iothings.entity.ResourceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Huanglei
 * @time:2020/10/28 10:18 AM
 * @Description：
 */
public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {

}
