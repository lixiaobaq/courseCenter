package com.iothings.service.impl;

import com.iothings.dao.CourseNotesRepository;
import com.iothings.entity.CourseNotes;
import com.iothings.service.CourseNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/9 10:03
 * @Description
 */
@Service
public class CourseNotesServiceImpl implements CourseNotesService {
    @Autowired
    private CourseNotesRepository repository;
    @Override
    public CourseNotes save(CourseNotes courseNotes) {
        return null;
    }

    @Override
    public List<CourseNotes> findByCourseId(Integer id) {
        return repository.findByCourseId(id);
    }

    @Override
    public void delete(Integer id) {

    }
}
