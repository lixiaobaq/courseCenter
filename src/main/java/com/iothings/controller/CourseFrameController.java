package com.iothings.controller;

import com.alibaba.fastjson.JSONObject;
import com.iothings.VO.CourseFrameVO;
import com.iothings.VO.ResultVO;
import com.iothings.dto.CourseFrameDTO;
import com.iothings.entity.CourseFrame;
import com.iothings.enums.ResultEnum;
import com.iothings.service.impl.CourseFrameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.ResultVOUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Alex
 * @time:2020/10/29 8:00 PM
 * @Description：
 */
@RestController
@RequestMapping("/api/style/")
public class CourseFrameController {

    @Autowired
    private CourseFrameServiceImpl courseFrameService;
    @GetMapping("list")
    public ResultVO list(){
        try {
            CourseFrameVO courseFrameVO=new CourseFrameVO();
            List<CourseFrame> courseFramelist=courseFrameService.getTree(ResultEnum.STATUS_TYPE_UP.getCode());
            courseFrameVO.setList(courseFramelist);
            System.out.println(JSONObject.toJSONString(courseFrameVO));
            return ResultVOUtil.success(Arrays.asList(courseFrameVO));
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }

    @PostMapping("add")
    public ResultVO add(@RequestParam("name")String name,@RequestParam("Level")String Level,@RequestParam("Parentid")String Parentid,@RequestParam("Sort")String Sort){
        try {
            CourseFrame courseFrame= new CourseFrame();
            courseFrame.setName(name);
            courseFrame.setLevel(Integer.parseInt(Level));
            courseFrame.setParentid(Integer.parseInt(Parentid));
            courseFrame.setStatus(ResultEnum.STATUS_TYPE_DOWN.getCode());
            courseFrame.setSort(Sort);
            CourseFrame CourseFrame2=courseFrameService.save(courseFrame);
            System.out.println(JSONObject.toJSONString(CourseFrame2));
            return ResultVOUtil.success(CourseFrame2);
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }
    @PostMapping("edit")
    public ResultVO edit(@RequestParam("id")String id,@RequestParam("name")String name,@RequestParam("releas_status")String releas_status){
        try {
            CourseFrame courseFrame= new CourseFrame();
            courseFrame.setId(Long.valueOf(id));
            courseFrame.setName(name);
            courseFrame.setStatus(Integer.parseInt(releas_status));
            CourseFrame CourseFrame2=courseFrameService.save(courseFrame);
            System.out.println(JSONObject.toJSONString(CourseFrame2));
            return ResultVOUtil.success(CourseFrame2);
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.EDIT_ERROR.getMessage());
        }
    }

    @PostMapping("delete")
    public ResultVO edit(@RequestParam("id")Integer id){
        try {
            courseFrameService.delete(id);
            return ResultVOUtil.success(ResultEnum.DELETE_SUCCES.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.DELETE_ERROR.getMessage());
        }
    }

    @PostMapping("sort")
    public ResultVO sort(@RequestParam("id")Integer id,@RequestParam("parentId")Integer parentId,@RequestParam("sort")Integer sort){
        try {
            Integer courseFrame= courseFrameService.updataByid(id,parentId,sort);
            return ResultVOUtil.success(courseFrame);
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }
}
