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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CourseFrameRepositoryTest {
    @Autowired
    private CourseFrameRepository courseFrameRepository;


    @Test
    @Transactional
    public void saveTest(){
        CourseFrame courseFrame=new CourseFrame();
        courseFrame.setLevel(1);
        courseFrame.setName("中文不好使？");
        courseFrame.setParentId(0);
        courseFrame.setStatus(0);
        courseFrame.setSort("1");
        courseFrame.setIsOpen("0");
        courseFrame= courseFrameRepository.save(courseFrame);
        System.out.println(JSONObject.toJSONString(courseFrame));
        Assert.assertNotNull(courseFrame);
    }
    @Test
    public void findByParentId(){
        List<CourseFrame> courseFrame=courseFrameRepository.findByParentId(1);
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
    public void findByParentIdAndStatus(){
        List<CourseFrame> courseFrame=courseFrameRepository.findByParentIdAndStatus(0,2);
        System.out.println("lieb:"+JSONObject.toJSONString(courseFrame));
        Assert.assertNotEquals(0,courseFrame.size());
    }
}