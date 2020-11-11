package com.iothings.controller;

import com.alibaba.fastjson.JSONObject;
import com.iothings.VO.CourseNotesVO;
import com.iothings.VO.ResultVO;
import com.iothings.entity.CourseNotes;
import com.iothings.enums.ResultEnum;
import com.iothings.form.CourseNotesForm;
import com.iothings.service.impl.CourseNotesServiceImpl;
import com.iothings.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/9 10:06
 * @Description
 */
@RestController
@RequestMapping("/api/courseNotes/")
public class CourseNotesController {
    @Autowired
    private CourseNotesServiceImpl service;
    @PostMapping("/list")
    public ResultVO list(CourseNotesForm courseNotesForm){
        try {
            CourseNotesVO courseNotesVO=new CourseNotesVO();
            List<CourseNotes> courseNoteslist=service.findByCourseId(Integer.parseInt(courseNotesForm.getId()));
            courseNotesVO.setList(courseNoteslist);
            System.out.println(JSONObject.toJSONString(courseNotesVO));
            return ResultVOUtil.success(Arrays.asList(courseNotesVO));
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }
}
