package com.iothings.controller;

import com.alibaba.fastjson.JSONObject;
import com.iothings.VO.BusinessVO;
import com.iothings.VO.CourseFrameVO;
import com.iothings.VO.ResultVO;
import com.iothings.entity.Business;
import com.iothings.entity.CourseFrame;
import com.iothings.enums.ResultEnum;
import com.iothings.form.BusinessForm;
import com.iothings.form.CourseFrameForm;
import com.iothings.service.impl.BusinessServiceImpl;
import com.iothings.util.ResultVOUtil;
import com.iothings.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResultVO add(@RequestParam("name")String name,@RequestParam("parent_id")String parentId){
        try {
            //判断参数是否为空
            if(StringUtil.isNotEmpty(name) || StringUtil.isNotEmpty(parentId)){
                Business business= new Business();
                business.setName(name);
                business.setParentId(Integer.parseInt(parentId));
                business.setStatus(ResultEnum.STATUS_TYPE_DOWN.getCode());
                business.setSort(ResultEnum.STATUS_TYPE_DOWN.getCode().toString());
                business=service.save(business);
                System.out.println(JSONObject.toJSONString(business));
                return ResultVOUtil.success(business);
            }else{
                return ResultVOUtil.success(ResultEnum.PARAM_ERROR.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }
    @PostMapping("edit")
    public ResultVO edit(@Valid BusinessForm businessForm){
        try {
            Business business = service.edit(businessForm);
            System.out.println(JSONObject.toJSONString(business));
            return ResultVOUtil.success(business);
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.EDIT_ERROR.getMessage());
        }
    }

    @PostMapping("delete")
    public ResultVO edit(@RequestParam("id")String id){
        ResultVO resultVO = new ResultVO();
        if(StringUtil.isNotEmpty(id)){
            //先根据ID查询数据是否持久化 后在删除
            if(service.existsById(Integer.parseInt(id))){
                service.delete(Integer.parseInt(id));
                resultVO = ResultVOUtil.success(ResultEnum.DELETE_SUCCES.getMessage());
            }else{
                resultVO = ResultVOUtil.success(ResultEnum.EXISTS_ERROR.getMessage());
            }
        }else{
            resultVO = ResultVOUtil.error(ResultEnum.PARAM_ERROR.getMessage());
        }
        return resultVO;
    }
    @PostMapping("sort")
    public ResultVO sort(@RequestParam("id")String id,@RequestParam("parentId")String parentId,@RequestParam("sort")String sort){
        try {
            //判断参数是否为空
            if(StringUtil.isNotEmpty(id) || StringUtil.isNotEmpty(parentId) || StringUtil.isNotEmpty(sort)){
                Business business = service.updataByid(Integer.parseInt(id),Integer.parseInt(parentId),Integer.parseInt(sort));
                return ResultVOUtil.success(business.getId());
            }else{
                return ResultVOUtil.success(ResultEnum.PARAM_ERROR.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }
}