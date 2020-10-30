package com.iothings.service;

import com.iothings.entity.ProductCategory;

import java.util.List;

/**
 * @author: Huanglei
 * @time:2020/10/27 8:54 PM
 * @Description：
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);


    List<ProductCategory> findAll();


    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);


}
