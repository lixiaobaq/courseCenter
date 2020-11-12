package com.iothings.dao;


import com.iothings.entity.CourseNotes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/9 9:40
 * @Description
 */
public interface CourseNotesRepository extends JpaRepository<CourseNotes,Long> {
    List<CourseNotes> findByCourseId(Integer id);
}
