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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/9 10:06
 * @Description
 */
@RestController
@RequestMapping("/api")
public class CourseNotesController {
    @Autowired
    private CourseNotesServiceImpl service;
    @PostMapping("/courseNotes")
    public ResultVO courseNotes(@RequestParam("id")String id,@RequestParam("token")String token){
        //TOOD 等待token接口
        String userId="1";
        try {
            if(userId!=null){
                List<CourseNotes> courseNoteslist=service.findByCourseId(Integer.parseInt(id));
                System.out.println(JSONObject.toJSONString(courseNoteslist));
                return ResultVOUtil.success(Arrays.asList(courseNoteslist));
            }else{
                return ResultVOUtil.success(ResultEnum.TOKEN_INVALID.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }
    @PostMapping("/saveCourseNotes")
    public ResultVO saveCourseNotes(CourseNotesForm courseNotesForm, @RequestParam("token")String token){
        //TOOD 等待token接口
        String userId="1";
        try {
            if(userId!=null){
                courseNotesForm.setUserId(userId);
                CourseNotes courseNotes=service.save(courseNotesForm);
                System.out.println(JSONObject.toJSONString(courseNotes));
                return ResultVOUtil.success(Arrays.asList(courseNotes));
            }else{
                return ResultVOUtil.success(ResultEnum.TOKEN_INVALID.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }
}
