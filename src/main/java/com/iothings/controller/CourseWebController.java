package com.iothings.controller;

import com.iothings.VO.KeywordVO;
import com.iothings.VO.PageVO;
import com.iothings.VO.ResultWebVO;
import com.iothings.entity.*;
import com.iothings.enums.ResultEnum;
import com.iothings.form.CourseForm;
import com.iothings.service.impl.CourseWebServiceImpl;
import com.iothings.util.Pages;
import com.iothings.util.PagesUtils;
import com.iothings.util.ResultVOUtil;
import com.iothings.util.ResultWebVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
     *
     * @param courseForm
     * @return
     */
    @PostMapping("/curriculumEvaluation")
    public ResultWebVO curriculumEvaluation(@RequestBody @Valid CourseForm courseForm) {
        ResultWebVO resultVO = new ResultWebVO();
        try {
            CourseCommentEntity courseCommentEntity = courseWebServiceImpl.addCurriculumEvaluation(courseForm);
            resultVO = ResultWebVOUtil.success(courseCommentEntity);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultWebVOUtil.save_error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 获取我的课程
     *
     * @return
     */
    @PostMapping("/myCourse")
    public ResultWebVO<Page<CourseEntity>> myCourse(Pages pages) {
        ResultWebVO resultVO = new ResultWebVO();
        try {
            Page page = courseWebServiceImpl.findCourseAllByCreaterId(PagesUtils.createPageRequest(pages), 1l);
            PageVO pageVO = new PageVO();
            pageVO.setPaseSize(pages.getPageSize());
            pageVO.setPageNo(pages.getPageNo());
            pageVO.setTotal((int) page.getTotalElements());
            pageVO.setDataList(page.getContent());
            resultVO = ResultWebVOUtil.success(pageVO);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultWebVOUtil.save_error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 获取推荐课程
     *
     * @return
     */
    @PostMapping("/recommendedCourses")
    public ResultWebVO<Page<CoursePublishEntity>> recommendedCourses(Pages pages, KeywordVO keywordVO) {
        ResultWebVO resultVO = new ResultWebVO();
        try {
            Page page = courseWebServiceImpl.findRecommendedCoursesAll(PagesUtils.createPageRequest(pages), keywordVO);
            PageVO pageVO = new PageVO();
            pageVO.setPaseSize(pages.getPageSize());
            pageVO.setPageNo(pages.getPageNo());
            pageVO.setTotal((int) page.getTotalElements());
            pageVO.setDataList(page.getContent());
            resultVO = ResultWebVOUtil.success(pageVO);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultWebVOUtil.save_error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 获取推荐直播 暂无直播
     *
     * @return
     */
    @PostMapping("/liveRecommended")
    public ResultWebVO liveRecommended() {
        ResultWebVO resultVO = new ResultWebVO();
        try {
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultWebVOUtil.save_error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 搜索课程名称 暂不开发 等待完善参数
     *
     * @return
     */
    @PostMapping("/searchForCourseName")
    public ResultWebVO searchForCourseName() {
        ResultWebVO resultVO = new ResultWebVO();
        try {
            resultVO = ResultWebVOUtil.success("");
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultWebVOUtil.save_error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 获取课程目录
     * @param id
     * @return
     */
    @PostMapping("/courseCatalogue")
    public ResultWebVO courseCatalogue(@RequestBody @Valid String id) {
        ResultWebVO resultVO = new ResultWebVO();
        try {
            List<CourseCatalogEntity> courseCatalog = courseWebServiceImpl.findCourseCatalogAll(Long.parseLong(id));
            resultVO = ResultWebVOUtil.success(courseCatalog);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultWebVOUtil.save_error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 获取课程视频 - 资源
     * @param id
     * @return
     */
    @PostMapping("/courseVideo")
    public ResultWebVO courseVideo(@RequestBody @Valid String id) {
        ResultWebVO resultVO = new ResultWebVO();
        try {
            ResourcePublishEntity resourcePublishEntity = courseWebServiceImpl.findResourcePublishById(Long.parseLong(id));
            resultVO = ResultWebVOUtil.success(resourcePublishEntity.getResourseUrl());
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultWebVOUtil.save_error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }
}
