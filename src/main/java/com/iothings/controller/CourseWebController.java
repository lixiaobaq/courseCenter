package com.iothings.controller;

import com.iothings.VO.PageVO;
import com.iothings.VO.ResultWebVO;
import com.iothings.entity.CourseCommentEntity;
import com.iothings.entity.CourseEntity;
import com.iothings.entity.CoursePublishEntity;
import com.iothings.enums.ResultEnum;
import com.iothings.form.CourseForm;
import com.iothings.service.impl.CourseWebServiceImpl;
import com.iothings.util.ResultWebVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: GuoYan
 * @time:2020/10/29 8:00 PM
 * @Description：
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class CourseWebController {

    @Autowired
    private CourseWebServiceImpl courseWebServiceImpl;

    /**
     * 添加课程评价
     * @param courseForm
     * @return
     */
    @PostMapping("curriculumEvaluation")
    public ResultWebVO curriculumEvaluation(@RequestBody @Valid CourseForm courseForm) {
        ResultWebVO resultVO = new ResultWebVO();
        try {
            CourseCommentEntity courseCommentEntity = courseWebServiceImpl.addCurriculumEvaluation(courseForm);
            resultVO = ResultWebVOUtil.success(courseCommentEntity);
        }catch (Exception e){
            e.printStackTrace();
            resultVO = ResultWebVOUtil.save_error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 获取我的课程
     * @param courseForm
     * @return
     */
    @PostMapping("myCourse")
    public ResultWebVO myCourse(@RequestBody @Valid CourseForm courseForm) {
        ResultWebVO resultVO = new ResultWebVO();
        try {
            Integer paseSize = courseForm.getPageSize();
            Integer pageNo = courseForm.getPageOn();
            List<CourseEntity> courseEntityList = courseWebServiceImpl.findCourseAllByCreaterId(paseSize, pageNo, 1l);
            Integer total = courseWebServiceImpl.findCourseAllNumbersByCreaterId(1l);
            PageVO pageVO = new PageVO();
            pageVO.setDataList(courseEntityList);
            pageVO.setPaseSize(paseSize);
            pageVO.setPageNo(pageNo);
            pageVO.setTotal(total);
            resultVO = ResultWebVOUtil.success(pageVO);
        }catch (Exception e){
            e.printStackTrace();
            resultVO = ResultWebVOUtil.save_error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 获取推荐课程
     * @param courseForm
     * @return
     */
    @PostMapping("recommendedCourses")
    public ResultWebVO recommendedCourses(@RequestBody @Valid CourseForm courseForm) {
        ResultWebVO resultVO = new ResultWebVO();
        try {
            List<CoursePublishEntity> courseEntityList = courseWebServiceImpl.findRecommendedCoursesAll(courseForm);
            Integer total = courseWebServiceImpl.findRecommendedCoursesAllNumbers(courseForm);
            PageVO pageVO = new PageVO();
            pageVO.setDataList(courseEntityList);
            pageVO.setPaseSize(courseForm.getPageSize());
            pageVO.setPageNo(courseForm.getPageOn());
            pageVO.setTotal(total);
            resultVO = ResultWebVOUtil.success(pageVO);
        }catch (Exception e){
            e.printStackTrace();
            resultVO = ResultWebVOUtil.save_error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 获取推荐直播
     * @return
     */
    @PostMapping("liveRecommended")
    public ResultWebVO liveRecommended() {
        ResultWebVO resultVO = new ResultWebVO();
        try {
        }catch (Exception e){
            e.printStackTrace();
            resultVO = ResultWebVOUtil.save_error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 搜索课程名称
     * @return
     */
    @PostMapping("searchForCourseName")
    public ResultWebVO searchForCourseName() {
        ResultWebVO resultVO = new ResultWebVO();
        try {
        }catch (Exception e){
            e.printStackTrace();
            resultVO = ResultWebVOUtil.save_error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }
}
