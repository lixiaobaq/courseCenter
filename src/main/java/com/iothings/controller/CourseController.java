package com.iothings.controller;

import com.iothings.VO.HeadVO;
import com.iothings.VO.PageVO;
import com.iothings.VO.ResultVO;
import com.iothings.entity.CourseEntity;
import com.iothings.entity.CoursePublishEntity;
import com.iothings.entity.GraphicEntity;
import com.iothings.enums.ResultEnum;
import com.iothings.form.CourseForm;
import com.iothings.service.impl.CourseServiceImpl;
import com.iothings.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.util.List;

/**
 * 后台课程接口
 * @author: GuoYan
 * @time:2020/10/29 8:00 PM
 * @Description：
 */
@RestController
@RequestMapping("/api/course")
@Slf4j
public class CourseController {

    @Autowired
    private CourseServiceImpl courseServiceImpl;

    /**
     * 条件获取课程列表带分页
     * @param paseSize
     * @param pageNo
     * @param keywords
     * @param keywordType
     * @param industry
     * @param verifyStatus
     * @param styleId
     * @return
     */
    @GetMapping("/list")
    public ResultVO list(@RequestParam("pase_size") String paseSize,
                         @RequestParam("page_no") String pageNo,
                         @RequestParam(value = "keywords", required =  false) String keywords,
                         @RequestParam(value = "keyword_type", required =  false) String keywordType,
                         @RequestParam(value = "industry", required =  false) String industry,
                         @RequestParam(value = "verify_status", required =  false) String verifyStatus,
                         @RequestParam(value = "style_id", required =  false) String styleId) {
        ResultVO resultVO = new ResultVO();
        try {
            List<CoursePublishEntity> course = courseServiceImpl.findAll(Integer.parseInt(paseSize), Integer.parseInt(pageNo), keywords, keywordType, industry, verifyStatus, styleId);
            Integer total = courseServiceImpl.findCourseAllNumbers();
            PageVO pageVO = new PageVO();
            pageVO.setDataList(course);
            pageVO.setPaseSize(Integer.parseInt(paseSize));
            pageVO.setPageNo(Integer.parseInt(pageNo));
            pageVO.setTotal(total);
            resultVO = ResultVOUtil.success(pageVO);
        }catch (Exception e){
            e.printStackTrace();
            resultVO = ResultVOUtil.error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 添加课程
     * @param courseForm
     * @return
     */
    @PostMapping("add")
    public ResultVO add(@RequestBody @Valid CourseForm courseForm) {
        ResultVO resultVO = new ResultVO();
        try {
            CourseEntity courseEntity = courseServiceImpl.addCourse(courseForm);
            resultVO = ResultVOUtil.success(courseEntity);
        }catch (Exception e){
            e.printStackTrace();
            resultVO = ResultVOUtil.error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 主键删除课程
     * @param id
     * @return
     */
    @PostMapping("delete")
    public ResultVO delete(@RequestBody @Valid String id) {
        ResultVO resultVO = new ResultVO();
        try {
            courseServiceImpl.delete(Long.parseLong(id));
            resultVO = ResultVOUtil.success("");
        }catch (Exception e){
            e.printStackTrace();
            resultVO = ResultVOUtil.error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 审核课程
     * @param courseForm
     * @return
     */
    @PostMapping("verify")
    public ResultVO verify(@RequestBody @Valid CourseForm courseForm) {
        ResultVO resultVO = new ResultVO();
        try {
            CourseEntity courseEntity = courseServiceImpl.verifyCourse(courseForm);
            resultVO = ResultVOUtil.success(courseEntity);
        }catch (Exception e){
            e.printStackTrace();
            resultVO = ResultVOUtil.error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 课程批量删除
     * @param ids
     * @return
     */
    @PostMapping("batch_delete")
    public ResultVO batchDelete(@RequestBody @Valid String ids) {
        ResultVO resultVO = new ResultVO();
        try {
            courseServiceImpl.batchDelete(ids);
            resultVO = ResultVOUtil.success("");
        }catch (Exception e){
            e.printStackTrace();
            resultVO = ResultVOUtil.error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 课程提交审核
     * @param id
     * @return
     */
    @PostMapping("action")
    public ResultVO action(@RequestBody @Valid String id) {
        ResultVO resultVO = new ResultVO();
        try {
            courseServiceImpl.saveCoursePublishById(Long.parseLong(id));
            resultVO = ResultVOUtil.success("");
        }catch (Exception e){
            e.printStackTrace();
            resultVO = ResultVOUtil.error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    @PostMapping("album_up")
    public ResultVO albumUp(@RequestBody @Valid File file) {
        ResultVO resultVO = new ResultVO();
        try {
            String url = courseServiceImpl.uploadImg(file);
            resultVO = ResultVOUtil.success("");
        }catch (Exception e){
            e.printStackTrace();
            resultVO = ResultVOUtil.error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

}
