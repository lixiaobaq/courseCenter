package com.iothings.dao;

import com.iothings.entity.CourseCatalogEntity;
import com.iothings.entity.CourseEntity;
import com.iothings.entity.CoursePublishEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseCatalogRepository courseCatalogRepository;

    @Test
    @Transactional
    public void saveTest(){
        CoursePublishEntity courseEntity=new CoursePublishEntity();

        courseEntity.setTitle("工业互联网2223");
        courseEntity.setSubTitle("这是一本工业互333联的书");
        courseEntity.setSummary("简介999999");
        courseRepository.save(courseEntity);
    }

    @Test
    @Transactional
    public void saveCourseModel(){
        CourseCatalogEntity c = new CourseCatalogEntity();
        c.setCourseId(1l);
        c.setLevelOf(1l);
        c.setIndexOf(1l);
        c.setParentId(1l);
        c.setIcon("copy");
        c.setTitle("测试版本");
        c.setType("0");
        c.setResourceId(1l);
        c.setTaskId(1l);
        courseCatalogRepository.save(c);
    }
}