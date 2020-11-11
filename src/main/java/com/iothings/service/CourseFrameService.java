package com.iothings.service;

import com.iothings.dto.CourseFrameDTO;
import com.iothings.entity.CourseFrame;
import com.iothings.form.CourseFrameForm;

import java.util.List;

/**
 * @author: Alex
 * @time:2020/10/29 10:29 PM
 * @Description：课程分类
 */
public interface CourseFrameService {

    CourseFrame save(CourseFrame courseClassify);

    CourseFrame edit(CourseFrameForm courseFrameForm);

    public List<CourseFrame> getTree(Integer status);

    public List<CourseFrame> getTreeAndCourseCounts(Integer status);

    public void delete(Integer id);

    public CourseFrame updataByid(Integer id,Integer pid,Integer sort);

    public boolean existsById(Integer id);
}
