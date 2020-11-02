package com.iothings.dao;

import com.alibaba.fastjson.JSONObject;
import com.iothings.entity.CourseFrame;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CourseFrameRepositoryTest {
    @Autowired
    private CourseFrameRepository courseFrameRepository;


    @Test
//    @Transactional
    public void saveTest(){
        CourseFrame courseFrame=new CourseFrame();
        courseFrame.setLevel(1);
        courseFrame.setName("第四个课程分类");
        courseFrame.setParentid(3);
        courseFrame.setStatus(0);
        courseFrameRepository.save(courseFrame);
    }
    @Test
    public void getListCourseFrame(){
        List<CourseFrame> courseFrame= courseFrameRepository.findByIdss(2l);
        System.out.println("lieb:"+JSONObject.toJSONString(courseFrame));
    }
    @Test
    public void findBypid(){
        List<CourseFrame> courseFrame=courseFrameRepository.findByParentid(1);
        System.out.println("lieb:"+JSONObject.toJSONString(courseFrame));
        Assert.assertNotEquals(0,courseFrame.size());
    }
}