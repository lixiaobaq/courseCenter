package com.iothings.dao;

import com.iothings.entity.CourseEntity;
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


    @Test
    @Transactional
    public void saveTest(){
        CourseEntity courseEntity=new CourseEntity();

        courseEntity.setTilte("工业互联网2223");
        courseEntity.setSubTitle("这是一本工业互333联的书");
        courseEntity.setSummary("简介999999");
        courseRepository.save(courseEntity);
    }
}