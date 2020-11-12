package com.iothings.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.iothings.entity.Business;
import com.iothings.form.BusinessForm;
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
public class BusinessServiceImplTest {

    @Autowired
    private BusinessServiceImpl serviceImpl;

    @Test
    @Transactional
    public void saveTest() {
        Business business=new Business();
        business.setLevel(1);
        business.setName("测试");
        business.setParentId(0);
        business.setStatus(0);
        business.setSort("1");
        business.setIsOpen("0");
        business = serviceImpl.save(business);
        System.out.println("lieb:"+ JSONObject.toJSONString(business));
        Assert.assertNotNull(business);
    }
    @Test
    @Transactional
    public void editTest() {
        BusinessForm businessForm=new BusinessForm();
        businessForm.setId(31l);
        businessForm.setName("测试名");
        businessForm.setReleas_status(1);
        Business business=serviceImpl.edit(businessForm);
        System.out.println("lieb:"+ JSONObject.toJSONString(business));
        Assert.assertNotNull(business);
    }
    /**
     * 测试获取课程分类树
     */
    @Test
    public void getTreeTest(){
        List<Business> business=serviceImpl.getTree(0);
       // System.out.println("lieb:"+JSONObject.toJSONString(courseFrame));
        Assert.assertNotEquals(0,business.size());
    }

    @Test
    public void getTreeAndCourseCountsTest(){
        List<Business> business=serviceImpl.getTreeAndCourseCounts(0);
        // System.out.println("lieb:"+JSONObject.toJSONString(courseFrame));
        Assert.assertNotEquals(0,business.size());
    }
}