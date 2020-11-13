package com.iothings.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.iothings.entity.CourseFrame;
import com.iothings.entity.CourseNotes;
import com.iothings.form.CourseNotesForm;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/13 9:19
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseNotesServiceImplTest{
    @Autowired
    private CourseNotesServiceImpl service;

    @Test
    @Transactional
    public void saveTest() {
        CourseNotesForm courseNotesForm=new CourseNotesForm();
        courseNotesForm.setUserId("1");
        courseNotesForm.setLinkCourseTime("00:00:15");
        courseNotesForm.setCourseId(1);
        courseNotesForm.setContent("dsdsdsd");
        CourseNotes result = service.save(courseNotesForm);
        System.out.println("lieb:"+ JSONObject.toJSONString(result));
        Assert.assertNotNull(result);
    }
    @Test
    public void findByCourseIdTest() {
        List<CourseNotes> result = service.findByCourseId(1);
        System.out.println("lieb:"+ JSONObject.toJSONString(result));
        Assert.assertNotEquals(0,result.size());
    }
    @Test
    public void existsByIdTest() {
        Boolean result = service.existsById(1);
        System.out.println("lieb:"+ JSONObject.toJSONString(result));
        Assert.assertNotEquals(false,result);
    }

    @Test
    @Transactional
    public void deleteTest() {
        service.delete(1);
    }
}