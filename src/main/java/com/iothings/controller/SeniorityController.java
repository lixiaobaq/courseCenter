package com.iothings.controller;

import com.alibaba.fastjson.JSONObject;
import com.iothings.VO.ResultVO;
import com.iothings.VO.SeniorityVO;
import com.iothings.entity.Seniority;
import com.iothings.enums.ResultEnum;
import com.iothings.service.impl.SeniorityServiceImpl;
import com.iothings.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/7 16:18
 * @Description
 */
@RestController
@RequestMapping("/api/seniority/")
public class SeniorityController {
    @Autowired
    private SeniorityServiceImpl service;

    @GetMapping("/list")
    public ResultVO list(){
        try {
            SeniorityVO seniorityVO=new SeniorityVO();
            List<Seniority> courseFramelist=service.getTree(ResultEnum.STATUS_TYPE_UP.getCode());
            seniorityVO.setList(courseFramelist);
            System.out.println(JSONObject.toJSONString(seniorityVO));
            return ResultVOUtil.success(Arrays.asList(seniorityVO));
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }
    @PostMapping("add")
    public ResultVO add(@RequestParam("name")String name, @RequestParam("Level")String Level, @RequestParam("Parentid")String Parentid, @RequestParam("Sort")String Sort){
        try {
            Seniority seniority= new Seniority();
            seniority.setName(name);
            seniority.setLevel(Integer.parseInt(Level));
            seniority.setParentid(Integer.parseInt(Parentid));
            seniority.setStatus(ResultEnum.STATUS_TYPE_DOWN.getCode());
            seniority.setSort(Sort);
            Seniority seniority1=service.save(seniority);
            System.out.println(JSONObject.toJSONString(seniority1));
            return ResultVOUtil.success(seniority1.getId());
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.ADD_ERROR.getMessage());
        }
    }
    @PostMapping("edit")
    public ResultVO edit(@RequestParam("id")String id,@RequestParam("name")String name,@RequestParam("releas_status")String releas_status){
        try {
            Seniority seniority= new Seniority();
            seniority.setId(Long.valueOf(id));
            seniority.setName(name);
            seniority.setStatus(Integer.parseInt(releas_status));
            Seniority seniority2=service.save(seniority);
            System.out.println(JSONObject.toJSONString(seniority2));
            return ResultVOUtil.success(ResultEnum.EDIT_SUCCES.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.EDIT_ERROR.getMessage());
        }
    }

    @PostMapping("delete")
    public ResultVO edit(@RequestParam("id")Integer id){
        try {
            service.delete(id);
            return ResultVOUtil.success(ResultEnum.DELETE_SUCCES.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.DELETE_ERROR.getMessage());
        }
    }
    @PostMapping("sort")
    public ResultVO sort(@RequestParam("id")Integer id,@RequestParam("parentId")Integer parentId,@RequestParam("sort")Integer sort){
        try {
            Integer courseFrame= service.updataByid(id,parentId,sort);
            return ResultVOUtil.success(courseFrame);
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }
}
