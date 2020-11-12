package com.iothings.service;

import com.iothings.entity.CourseNotes;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/9 9:56
 * @Description
 */
public interface CourseNotesService {
    CourseNotes save(CourseNotes courseNotes);

    public List<CourseNotes> findByCourseId(Integer id);

    public void delete(Integer id);

}
