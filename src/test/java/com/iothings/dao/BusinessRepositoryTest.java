package com.iothings.dao;

import com.alibaba.fastjson.JSONObject;
import com.iothings.entity.Business;
import com.iothings.entity.CourseCatalogEntity;
import com.iothings.entity.CourseFrame;
import com.iothings.entity.CoursePublishEntity;
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
public class BusinessRepositoryTest {
    @Autowired
    private BusinessRepository repository;


    @Test
    @Transactional
    public void saveTest(){
        Business business=new Business();
        business.setLevel(1);
        business.setName("中文不好使？");
        business.setParentId(0);
        business.setStatus(0);
        business.setSort("1");
        business.setIsOpen("0");
        business= repository.save(business);
        System.out.println(JSONObject.toJSONString(business));
        Assert.assertNotNull(business);
    }
    @Test
    public void findByParentId(){
        List<Business> business=repository.findByParentId(1);
        System.out.println("lieb:"+JSONObject.toJSONString(business));
        Assert.assertNotEquals(0,business.size());
    }
    @Test
    public void findByStatus(){
        List<Business> business=repository.findByStatus(0);
        System.out.println("lieb:"+JSONObject.toJSONString(business));
        Assert.assertNotEquals(0,business.size());
    }
    @Test
    public void findByParentIdAndStatus(){
        List<Business> business=repository.findByParentIdAndStatus(0,2);
        System.out.println("lieb:"+JSONObject.toJSONString(business));
        Assert.assertNotEquals(0,business.size());
    }
}