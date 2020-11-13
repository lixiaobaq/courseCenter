package com.iothings.controller;

import com.alibaba.fastjson.JSONObject;
import com.iothings.VO.CourseFrameVO;
import com.iothings.VO.ResultVO;
import com.iothings.VO.ResultWebVO;
import com.iothings.entity.CourseFrame;
import com.iothings.enums.ResultEnum;
import com.iothings.form.CourseFrameForm;
import com.iothings.service.impl.CourseFrameServiceImpl;
import com.iothings.util.ResultVOUtil;
import com.iothings.util.ResultWebVOUtil;
import com.iothings.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Alex
 * @time:2020/10/29 8:00 PM
 * @Description：
 */
@RestController
@RequestMapping("/api")
public class CourseFrameController {

    @Autowired
    private CourseFrameServiceImpl courseFrameService;

    @GetMapping("/style/list")
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

    @GetMapping("/style/release_list")
    public ResultVO releaseList(){
        try {
            CourseFrameVO courseFrameVO=new CourseFrameVO();
            List<CourseFrame> courseFramelist=courseFrameService.getTree(ResultEnum.ALL_TYPE.getCode());
            courseFrameVO.setList(courseFramelist);
            System.out.println(JSONObject.toJSONString(courseFrameVO));
            return ResultVOUtil.success(Arrays.asList(courseFrameVO));
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }
    @GetMapping("/getCourseClassification")
    public ResultWebVO getCourseClassification(){
        try {
            CourseFrameVO courseFrameVO=new CourseFrameVO();
            List<CourseFrame> courseFramelist=courseFrameService.getTree(ResultEnum.STATUS_TYPE_UP.getCode());
            courseFrameVO.setList(courseFramelist);
            System.out.println(JSONObject.toJSONString(courseFrameVO));
            return ResultWebVOUtil.success(Arrays.asList(courseFrameVO));
        }catch (Exception e){
            e.printStackTrace();
            return ResultWebVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }

    @PostMapping("/style/add")
    public ResultVO add(@RequestParam("name")String name,@RequestParam("parent_id")String parentId){
        try {
            //判断参数是否为空
            if(StringUtil.isNotEmpty(name) || StringUtil.isNotEmpty(parentId)){
                CourseFrame courseFrame= new CourseFrame();
                courseFrame.setName(name);
                courseFrame.setParentId(Integer.parseInt(parentId));
                courseFrame.setStatus(ResultEnum.STATUS_TYPE_DOWN.getCode());
                courseFrame.setSort(ResultEnum.STATUS_TYPE_DOWN.getCode().toString());
                CourseFrame CourseFrame2=courseFrameService.save(courseFrame);
                System.out.println(JSONObject.toJSONString(CourseFrame2));
                return ResultVOUtil.success(CourseFrame2);
            }else{
                return ResultVOUtil.success(ResultEnum.PARAM_ERROR.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }
    @PostMapping("/style/edit")
    public ResultVO edit(@Valid CourseFrameForm courseFrameForm){
        try {
            CourseFrame CourseFrame2=courseFrameService.edit(courseFrameForm);
            System.out.println(JSONObject.toJSONString(CourseFrame2));
            return ResultVOUtil.success(CourseFrame2);
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.EDIT_ERROR.getMessage());
        }
    }

    @PostMapping("/style/delete")
    public ResultVO edit(@RequestParam("id")String id){
        ResultVO resultVO = new ResultVO();
        if(StringUtil.isNotEmpty(id)){
            //先根据ID查询数据是否持久化 后在删除
            if(courseFrameService.existsById(Integer.parseInt(id))){
                courseFrameService.delete(Integer.parseInt(id));
                resultVO = ResultVOUtil.success(ResultEnum.DELETE_SUCCES.getMessage());
            }else{
                resultVO = ResultVOUtil.success(ResultEnum.EXISTS_ERROR.getMessage());
            }
        }else{
            resultVO = ResultVOUtil.error(ResultEnum.PARAM_ERROR.getMessage());
        }
        return resultVO;
    }

    @PostMapping("/style/sort")
    public ResultVO sort(@RequestParam("id")String id,@RequestParam("parentId")String parentId,@RequestParam("sort")String sort){
        try {
            //判断参数是否为空
            if(StringUtil.isNotEmpty(id) || StringUtil.isNotEmpty(parentId) || StringUtil.isNotEmpty(sort)){
                CourseFrame courseFrame= courseFrameService.updataByid(Integer.parseInt(id),Integer.parseInt(parentId),Integer.parseInt(sort));
                return ResultVOUtil.success(courseFrame.getId());
            }else{
                return ResultVOUtil.success(ResultEnum.PARAM_ERROR.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.success(ResultEnum.MANAGER_ERROR.getMessage());
        }
    }
}