package com.iothings.dao;

import com.iothings.entity.CourseFrame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @author: Alex
 * @time:2020/10/29 10:29 PM
 * @Description：课程分类
 */
public interface CourseFrameRepository extends JpaRepository<CourseFrame,Long> {
    List<CourseFrame> findByParentId(Integer pid);

    List<CourseFrame> findByStatus(Integer status);

    List<CourseFrame> findByParentIdAndStatus(Integer parentId,Integer status);
}
