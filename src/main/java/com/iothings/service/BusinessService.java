package com.iothings.service;

import com.iothings.entity.Business;
import com.iothings.entity.CourseFrame;
import com.iothings.form.BusinessForm;
import com.iothings.form.CourseFrameForm;

import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/6 13:41
 * @Description
 */
public interface BusinessService {
    Business save(Business business);

    Business edit(BusinessForm businessForm);

    public List<Business> getTree(Integer status);

    public List<Business> getTreeAndCourseCounts(Integer status);

    public void delete(Integer id);

    public Business updataByid(Integer id,Integer pid,Integer sort);

    public boolean existsById(Integer id);
}
