package com.iothings.controller;

import com.alibaba.fastjson.JSONObject;
import com.iothings.VO.BusinessVO;
import com.iothings.VO.ResultVO;
import com.iothings.entity.Business;
import com.iothings.enums.ResultEnum;
import com.iothings.service.impl.BusinessServiceImpl;
import com.iothings.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/6 14:16
 * @Description
 */
@RestController
@RequestMapping("/api/business/")
public class BusinessController {
    @Autowired
    private BusinessServiceImpl service;

    @GetMapping("/list")
    public ResultVO list(){
        try {
            BusinessVO businessVO=new BusinessVO();
            List<Business> courseFramelist=service.getTree(ResultEnum.STATUS_TYPE_UP.getCode());
            businessVO.setList(courseFramelist);
            System.out.println(JSONObject.toJSONString(businessVO));
            return ResultVOUtil.success(Arrays.asList(businessVO));
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }
    @PostMapping("add")
    public ResultVO add(@RequestParam("name")String name, @RequestParam("Level")String Level, @RequestParam("Parentid")String Parentid, @RequestParam("Sort")String Sort){
        try {
            Business business= new Business();
            business.setName(name);
            business.setLevel(Integer.parseInt(Level));
            business.setParentid(Integer.parseInt(Parentid));
            business.setStatus(ResultEnum.STATUS_TYPE_DOWN.getCode());
            business.setSort(Sort);
            Business business1=service.save(business);
            System.out.println(JSONObject.toJSONString(business1));
            return ResultVOUtil.success(business1.getId());
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.ADD_ERROR.getMessage());
        }
    }
    @PostMapping("edit")
    public ResultVO edit(@RequestParam("id")String id,@RequestParam("name")String name,@RequestParam("releas_status")String releas_status){
        try {
            Business business= new Business();
            business.setId(Long.valueOf(id));
            business.setName(name);
            business.setStatus(Integer.parseInt(releas_status));
            Business CourseFrame2=service.save(business);
            System.out.println(JSONObject.toJSONString(CourseFrame2));
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