package com.iothings.service;

import com.iothings.entity.Business;
import com.iothings.entity.Seniority;
import com.iothings.form.BusinessForm;
import com.iothings.form.SeniorityForm;

import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/7 14:58
 * @Description
 */

public interface SeniorityService {
    Seniority save(Seniority seniority);

    Seniority edit(SeniorityForm seniorityForm);

    public List<Seniority> getTree(Integer status);

    public List<Seniority> getTreeAndCourseCounts(Integer status);

    public void delete(Integer id);

    public Seniority updataByid(Integer id,Integer pid,Integer sort);

    public boolean existsById(Integer id);
}
