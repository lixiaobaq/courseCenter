package com.iothings.controller;

import com.alibaba.fastjson.JSONObject;
import com.iothings.VO.CourseNotesVO;
import com.iothings.VO.ResultVO;
import com.iothings.VO.ResultWebVO;
import com.iothings.entity.CourseNotes;
import com.iothings.enums.ResultEnum;
import com.iothings.form.CourseNotesForm;
import com.iothings.service.impl.CourseNotesServiceImpl;
import com.iothings.util.ResultVOUtil;
import com.iothings.util.ResultWebVOUtil;
import com.iothings.util.StringUtil;
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
    public ResultWebVO courseNotes(@RequestParam("id")String id,@RequestParam("token")String token){
        //TOOD 等待token接口
        String userId="1";
        try {
            if(userId!=null){
                List<CourseNotes> courseNoteslist=service.findByCourseId(Integer.parseInt(id));
                System.out.println(JSONObject.toJSONString(courseNoteslist));
                return ResultWebVOUtil.success(Arrays.asList(courseNoteslist));
            }else{
                return ResultWebVOUtil.success(ResultEnum.TOKEN_INVALID.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultWebVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }
    @PostMapping("/saveCourseNotes")
    public ResultWebVO saveCourseNotes(CourseNotesForm courseNotesForm, @RequestParam("token")String token){
        //TOOD 等待token接口
        String userId="1";
        try {
            if(userId!=null){
                courseNotesForm.setUserId(userId);
                CourseNotes courseNotes=service.save(courseNotesForm);
                System.out.println(JSONObject.toJSONString(courseNotes));
                return ResultWebVOUtil.success(Arrays.asList(courseNotes));
            }else{
                return ResultWebVOUtil.save_error(ResultEnum.TOKEN_INVALID.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultWebVOUtil.save_error(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }
    @PostMapping("/delCourseNotes")
    public ResultWebVO delete(@RequestParam("videoId")String id, @RequestParam("token")String token){
        ResultWebVO resultVO = new ResultWebVO();
        //TOOD 等待token接口
        String userId="1";
        if(userId!=null){
            if(StringUtil.isNotEmpty(id)){
                //先根据ID查询数据是否持久化 后在删除
                if(service.existsById(Integer.parseInt(id))){
                    service.delete(Integer.parseInt(id));
                    resultVO = ResultWebVOUtil.success(ResultEnum.DELETE_SUCCES.getMessage());
                }else{
                    resultVO = ResultWebVOUtil.success(ResultEnum.EXISTS_ERROR.getMessage());
                }
            }else{
                resultVO = ResultWebVOUtil.user_null(ResultEnum.PARAM_ERROR.getMessage());
            }
            return resultVO;
        }else{
            return ResultWebVOUtil.save_error(ResultEnum.TOKEN_INVALID.getMessage());
        }
    }
}
