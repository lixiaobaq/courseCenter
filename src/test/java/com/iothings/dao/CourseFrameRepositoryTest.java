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
import java.util.Optional;

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
        courseFrame.setName("中文不好使？");
        courseFrame.setParentid(0);
        courseFrame.setStatus(0);
        courseFrame.setCoursenum(1);
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
    @Test
    public void findByStatus(){
        List<CourseFrame> courseFrame=courseFrameRepository.findByStatus(0);
        System.out.println("lieb:"+JSONObject.toJSONString(courseFrame));
        Assert.assertNotEquals(0,courseFrame.size());
    }

    @Test
    public void findCourseNumByFrame(){
        Integer courseFrame=courseFrameRepository.findCourseNumByFrame(13);
        System.out.println("lieb:"+courseFrame);
    }

    @Test
    public void updataByid(){
        Integer courseFrame1= courseFrameRepository.updataByid(1,10,5);
        System.out.println("后:"+courseFrame1);
    }
}