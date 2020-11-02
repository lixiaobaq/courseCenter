package com.iothings.dao;

import com.iothings.entity.CourseFrame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityResult;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import java.util.List;


/**
 * @author: Alex
 * @time:2020/10/29 10:29 PM
 * @Description：课程分类
 */
public interface CourseFrameRepository extends JpaRepository<CourseFrame,Long> {


    @Query(value = "SELECT * FROM course_frame WHERE id=?1",nativeQuery = true)
//    @SqlResultSetMappings({
//            @SqlResultSetMapping(name="studentInfo",entities=@EntityResult(entityClass=CourseFrame.class)),
//    })
    List<CourseFrame> findByIdss(Long id);

    List<CourseFrame> findByParentid(Integer pid);

    public static final String selectCourseFrameList = "SELECT * FROM course_frame WHERE id=?";
    public static final String deleteStudentId = "delete from student_info where stu_id = ? ";
    public static final String updateStudentId = " update student_inf set stu_name = ? where stu_id = ? ";

    public void selectCourseFrameList(EntityManager entitymanager, Integer id );

    public void deleteStudentById(EntityManager entitymanager, Integer id );

    public void updateStudentById(EntityManager entitymanager, Integer id );
}
