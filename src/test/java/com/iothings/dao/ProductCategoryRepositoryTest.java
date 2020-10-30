package com.iothings.dao;

import com.iothings.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory=repository.getOne(1);
        System.out.println(productCategory.toString());
    }
    @Test
    @Transactional  //测试数据不进库
    public void saveTest(){
        ProductCategory productCategory=new ProductCategory("证书1111",34);
        ProductCategory result=repository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void updateTest(){
        ProductCategory productCategory=repository.getOne(1);
        productCategory.setCategoryName("证书3");
        productCategory.setCategoryType(10);
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list= Arrays.asList(10,11);
        List<ProductCategory> result=repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}