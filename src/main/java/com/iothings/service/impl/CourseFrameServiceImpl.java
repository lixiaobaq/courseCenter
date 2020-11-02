package com.iothings.service.impl;

import com.iothings.dao.CourseFrameRepository;
import com.iothings.entity.CourseFrame;
import com.iothings.service.CourseFrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Alex
 * @time:2020/10/29 10:29 PM
 * @Description：课程分类
 */
@Service
public class CourseFrameServiceImpl implements CourseFrameService {

    @Autowired
    private CourseFrameRepository repository;

    @Override
    public CourseFrame save(CourseFrame courseClassify) {
        return repository.save(courseClassify);
    }
}
