package com.iothings.service;

import com.iothings.entity.Business;
import com.iothings.entity.CourseFrame;

import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/6 13:41
 * @Description
 */
public interface BusinessService {
    Business save(Business business);

    public List<Business> getTree(Integer status);

    public List<Business> getTreeAndCourseCounts(Integer status);

    public void delete(Integer id);

    public Integer updataByid(Integer id,Integer pid,Integer sort);
}
