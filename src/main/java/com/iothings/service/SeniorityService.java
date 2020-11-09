package com.iothings.service;

import com.iothings.entity.Seniority;

import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/7 14:58
 * @Description
 */

public interface SeniorityService {
    Seniority save(Seniority Seniority);

    public List<Seniority> getTree(Integer status);

    public List<Seniority> getTreeAndCourseCounts(Integer status);

    public void delete(Integer id);

    public Integer updataByid(Integer id,Integer pid,Integer sort);
}
