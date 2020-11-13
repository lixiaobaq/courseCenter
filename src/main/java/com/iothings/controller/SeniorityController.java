package com.iothings.controller;

import com.alibaba.fastjson.JSONObject;
import com.iothings.VO.ResultVO;
import com.iothings.VO.SeniorityVO;
import com.iothings.entity.Business;
import com.iothings.entity.Seniority;
import com.iothings.enums.ResultEnum;
import com.iothings.form.BusinessForm;
import com.iothings.form.SeniorityForm;
import com.iothings.service.impl.SeniorityServiceImpl;
import com.iothings.util.ResultVOUtil;
import com.iothings.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @GetMapping("/release_list")
    public ResultVO releaselist(){
        try {
            SeniorityVO seniorityVO=new SeniorityVO();
            List<Seniority> courseFramelist=service.getTree(ResultEnum.ALL_TYPE.getCode());
            seniorityVO.setList(courseFramelist);
            System.out.println(JSONObject.toJSONString(seniorityVO));
            return ResultVOUtil.success(Arrays.asList(seniorityVO));
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }
    @PostMapping("add")
    public ResultVO add(@RequestParam("name")String name,@RequestParam("parent_id")String parentId){
        try {
            if(StringUtil.isNotEmpty(name) || StringUtil.isNotEmpty(parentId)){
            Seniority seniority= new Seniority();
            seniority.setName(name);
            seniority.setParentId(Integer.parseInt(parentId));
            seniority.setStatus(ResultEnum.STATUS_TYPE_DOWN.getCode());
            seniority.setSort(ResultEnum.STATUS_TYPE_DOWN.getCode().toString());
            seniority=service.save(seniority);
            System.out.println(JSONObject.toJSONString(seniority));
            return ResultVOUtil.success(seniority.getId());
            }else{
                return ResultVOUtil.success(ResultEnum.PARAM_ERROR.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.ADD_ERROR.getMessage());
        }
    }
    @PostMapping("edit")
    public ResultVO edit(@Valid SeniorityForm seniorityForm){
        try {
            Seniority seniority = service.edit(seniorityForm);
            System.out.println(JSONObject.toJSONString(seniority));
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
    public ResultVO sort(@RequestParam("id")String id,@RequestParam("parentId")String parentId,@RequestParam("sort")String sort){
        try {
            Seniority seniority= service.updataByid(Integer.parseInt(id),Integer.parseInt(parentId),Integer.parseInt(sort));
            return ResultVOUtil.success(seniority);
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }
}
