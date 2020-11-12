package com.iothings.service;

import com.iothings.entity.CourseNotes;
import com.iothings.form.CourseNotesForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/9 9:56
 * @Description
 */
public interface CourseNotesService {
    /**
     * 新增与修改
     * @param courseNotesForm
     * @return
     */
    CourseNotes save(CourseNotesForm courseNotesForm);

    /**
     * 查询课程视频下的所有笔记
     * @return
     */
    public List<CourseNotes> findByCourseId(Integer id);

    /**
     * 判断数据是否存在
     * @param id
     * @return
     */
    public boolean existsById(Integer id);


    /**
     * 删除
     * @param id
     */
    public void delete(Integer id);

}
