package com.iothings.dao;

import com.alibaba.fastjson.JSONObject;
import com.iothings.entity.Business;
import com.iothings.entity.Seniority;
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
public class SeniorityRepositoryTest {
    @Autowired
    private SeniorityRepository repository;


    @Test
    //@Transactional
    public void saveTest(){
        Seniority seniority=new Seniority();
        seniority.setLevel(1);
        seniority.setName("中文不好使？");
        seniority.setParentId(0);
        seniority.setStatus(0);
        seniority.setSort("1");
        seniority.setIsOpen("0");
        seniority= repository.save(seniority);
        System.out.println(JSONObject.toJSONString(seniority));
        Assert.assertNotNull(seniority);
    }
    @Test
    public void findByParentId(){
        List<Seniority> seniority=repository.findByParentId(1);
        System.out.println("lieb:"+JSONObject.toJSONString(seniority));
        Assert.assertNotEquals(0,seniority.size());
    }
    @Test
    public void findByStatus(){
        List<Seniority> seniority=repository.findByStatus(0);
        System.out.println("lieb:"+JSONObject.toJSONString(seniority));
        Assert.assertNotEquals(0,seniority.size());
    }
    @Test
    public void findByParentIdAndStatus(){
        List<Seniority> seniority=repository.findByParentIdAndStatus(0,1);
        System.out.println("lieb:"+JSONObject.toJSONString(seniority));
        Assert.assertNotEquals(0,seniority.size());
    }
}