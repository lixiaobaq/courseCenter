package com.iothings.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.iothings.entity.Business;
import com.iothings.entity.Seniority;
import com.iothings.form.BusinessForm;
import com.iothings.form.SeniorityForm;
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
public class SeniorityServiceImplTest {

    @Autowired
    private SeniorityServiceImpl serviceImpl;

    @Test
    @Transactional
    public void saveTest() {
        Seniority seniority=new Seniority();
        seniority.setLevel(1);
        seniority.setName("测试");
        seniority.setParentId(0);
        seniority.setStatus(0);
        seniority.setSort("1");
        seniority.setIsOpen("0");
        seniority = serviceImpl.save(seniority);
        System.out.println("lieb:"+ JSONObject.toJSONString(seniority));
        Assert.assertNotNull(seniority);
    }
    @Test
    @Transactional
    public void editTest() {
        SeniorityForm seniorityForm=new SeniorityForm();
        seniorityForm.setId(31l);
        seniorityForm.setName("测试名");
        seniorityForm.setReleas_status(1);
        Seniority seniority=serviceImpl.edit(seniorityForm);
        System.out.println("lieb:"+ JSONObject.toJSONString(seniority));
        Assert.assertNotNull(seniority);
    }
    /**
     * 测试获取课程分类树
     */
    @Test
    public void getTreeTest(){
        List<Seniority> seniority=serviceImpl.getTree(0);
       // System.out.println("lieb:"+JSONObject.toJSONString(courseFrame));
        Assert.assertNotEquals(0,seniority.size());
    }

    @Test
    public void getTreeAndCourseCountsTest(){
        List<Seniority> seniority=serviceImpl.getTreeAndCourseCounts(0);
        // System.out.println("lieb:"+JSONObject.toJSONString(courseFrame));
        Assert.assertNotEquals(0,seniority.size());
    }
}