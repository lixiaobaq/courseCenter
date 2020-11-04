package com.iothings.dao;

import com.iothings.entity.CourseFrame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * @author: Alex
 * @time:2020/10/29 10:29 PM
 * @Description：课程分类
 */
public interface CourseFrameRepository extends JpaRepository<CourseFrame,Long> {

    @Query(value = "SELECT * FROM course_frame WHERE id=?1",nativeQuery = true)
    List<CourseFrame> findByIdss(Long id);

    List<CourseFrame> findByParentid(Integer pid);

    List<CourseFrame> findByStatus(Integer status);

    List<CourseFrame> findByParentidAndStatus(Integer parentid,Integer status);

    /**
     * 获取课程分类下的所有课程数量
     * @param id
     * @return
     */
    @Query(value = "SELECT  COUNT(*) FROM `course` WHERE FIND_IN_SET( ?1, frame_id) ",nativeQuery = true)
    Integer findCourseNumByFrame(Integer id);
}
