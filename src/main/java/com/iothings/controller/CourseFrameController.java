package com.iothings.controller;

import com.alibaba.fastjson.JSONObject;
import com.iothings.VO.CourseFrameVO;
import com.iothings.VO.ResultVO;
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
        CourseFrameVO courseFrameVO=new CourseFrameVO();
        List<CourseFrame> courseFramelist=courseFrameService.getTree(ResultEnum.STATUS_TYPE_UP.getCode());
        courseFrameVO.setList(courseFramelist);
        System.out.println(JSONObject.toJSONString(courseFrameVO));
        return ResultVOUtil.success(Arrays.asList(courseFrameVO));
    }

    @PostMapping("add")
    public ResultVO add(@RequestParam("name")String name,@RequestParam("Level")String Level,@RequestParam("Parentid")String Parentid,@RequestParam("Sort")String Sort){
        CourseFrame courseFrame= new CourseFrame();
        courseFrame.setName(name);
        courseFrame.setLevel(Integer.parseInt(Level));
        courseFrame.setParentid(Integer.parseInt(Parentid));
        courseFrame.setStatus(ResultEnum.STATUS_TYPE_DOWN.getCode());
        courseFrame.setSort(Sort);
        CourseFrame CourseFrame2=courseFrameService.save(courseFrame);
        System.out.println(JSONObject.toJSONString(CourseFrame2));
        return ResultVOUtil.success(CourseFrame2);
    }
    @PostMapping("edit")
    public ResultVO edit(@RequestParam("id")String id,@RequestParam("name")String name,@RequestParam("releas_status")String releas_status){
        CourseFrame courseFrame= new CourseFrame();
        courseFrame.setId(Long.valueOf(id));
        courseFrame.setName(name);
        courseFrame.setStatus(Integer.parseInt(releas_status));
        CourseFrame CourseFrame2=courseFrameService.save(courseFrame);
        System.out.println(JSONObject.toJSONString(CourseFrame2));
        return ResultVOUtil.success(CourseFrame2);
    }

    @PostMapping("delete")
    public ResultVO edit(@RequestParam("id")Integer id){
        courseFrameService.delete(id);
        return ResultVOUtil.success("删除成功");
    }
}
