package com.iothings.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.iothings.entity.CourseFrame;
import com.iothings.form.CourseFrameForm;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseFrameServiceImplTest {

    @Autowired
    private CourseFrameServiceImpl courseFrameServiceImpl;

    @Test
    @Transactional
    public void saveTest() {
        CourseFrame courseFrame=new CourseFrame();
        courseFrame.setLevel(1);
        courseFrame.setName("测试");
        courseFrame.setParentId(0);
        courseFrame.setStatus(0);
        courseFrame.setSort("1");
        courseFrame.setIsOpen("0");
        CourseFrame result = courseFrameServiceImpl.save(courseFrame);
        System.out.println("lieb:"+ JSONObject.toJSONString(result));
        Assert.assertNotNull(result);
    }
    @Test
    @Transactional
    public void editTest() {
        CourseFrameForm courseFrameForm=new CourseFrameForm();
        courseFrameForm.setId(31l);
        courseFrameForm.setName("测试名");
        courseFrameForm.setReleas_status(1);
        CourseFrame CourseFrame=courseFrameServiceImpl.edit(courseFrameForm);
        System.out.println("lieb:"+ JSONObject.toJSONString(CourseFrame));
        Assert.assertNotNull(CourseFrame);
    }
    /**
     * 测试获取课程分类树
     */
    @Test
    public void getTreeTest(){
        List<CourseFrame> courseFrame=courseFrameServiceImpl.getTree(0);
       // System.out.println("lieb:"+JSONObject.toJSONString(courseFrame));
        Assert.assertNotEquals(0,courseFrame.size());
    }

    @Test
    public void getTreeAndCourseCountsTest(){
        List<CourseFrame> courseFrame=courseFrameServiceImpl.getTreeAndCourseCounts(0);
        // System.out.println("lieb:"+JSONObject.toJSONString(courseFrame));
        Assert.assertNotEquals(0,courseFrame.size());
    }
}