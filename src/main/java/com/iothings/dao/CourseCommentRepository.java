package com.iothings.dao;

import com.iothings.entity.CourseCommentEntity;
import com.iothings.entity.CourseEntity;
import com.iothings.entity.CoursePublishEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 前端课程DAO控制层
 * @author: Guoyan
 */
public interface CourseCommentRepository extends JpaRepository<CourseCommentEntity, Long> {

}
