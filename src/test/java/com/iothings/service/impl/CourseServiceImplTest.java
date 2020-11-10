package com.iothings.service.impl;

import com.iothings.dao.CoursePublishRepository;
import com.iothings.entity.CoursePublishEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImplTest {

    @Autowired
    private CoursePublishRepository courseService;

    @Test
    public void findAll() {
//        List<CoursePublishEntity> coursePublishEntity = courseService.findAll(10, 0, "no_project", "1", "1", "", "1");
//        Assert.assertEquals(new ArrayList<CoursePublishEntity>(), coursePublishEntity);
    }

    @Test
    public void findCourseAllNumbers() {
        Integer nums = courseService.findCourseAllNumbers();
        Assert.assertEquals(new Integer(3), nums);
    }
}
