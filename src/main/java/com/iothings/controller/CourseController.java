package com.iothings.controller;

import com.iothings.VO.KeywordVO;
import com.iothings.VO.PageVO;
import com.iothings.VO.ResultVO;
import com.iothings.VO.ResultWebVO;
import com.iothings.entity.CourseEntity;
import com.iothings.entity.CoursePublishEntity;
import com.iothings.entity.ResourceEntity;
import com.iothings.enums.ResultEnum;
import com.iothings.form.CourseForm;
import com.iothings.service.impl.CourseServiceImpl;
import com.iothings.util.Pages;
import com.iothings.util.PagesUtils;
import com.iothings.util.ResultVOUtil;
import com.iothings.util.ResultWebVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;

/**
 * 后台课程接口
 *
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
     * 分页查询所有用户（动态页数，每页大小，排序方式，排序字段）
     * 包括动态条件查询（属性值）
     * 规则：无输入条件，默认查询全部。默认返回第一页 每页5条，默认asc排序，默认id排序。
     *
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
    public ResultWebVO<Page<CoursePublishEntity>> list(
            @RequestParam("pase_size") String paseSize,
            @RequestParam("page_no") String pageNo,
            @RequestParam(value = "keywords", required = false) String keywords,
            @RequestParam(value = "keyword_type", required = false) String keywordType,
            @RequestParam(value = "industry", required = false) String industry,
            @RequestParam(value = "verify_status", required = false) String verifyStatus,
            @RequestParam(value = "style_id", required = false) String styleId) {
        ResultWebVO resultVO = new ResultWebVO();
        try {
            Pages pages = new Pages();
            pages.setPageSize(Integer.parseInt(paseSize));
            pages.setPageNo(Integer.parseInt(pageNo));
            KeywordVO keywordVO = new KeywordVO();
            keywordVO.setKeywords(keywords);
            keywordVO.setKeywordType(keywordType);
            keywordVO.setIndustry(industry);
            keywordVO.setVerifyStatus(verifyStatus);
            keywordVO.setStyleId(styleId);
            Page page = courseServiceImpl.findCourseAll(PagesUtils.createPageRequest(pages), keywordVO);
            PageVO pageVO = new PageVO();
            pageVO.setPaseSize(Integer.parseInt(paseSize));
            pageVO.setPageNo(Integer.parseInt(pageNo));
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
     * 添加课程
     *
     * @param courseForm
     * @return
     */
    @PostMapping("/add")
    public ResultVO add(@RequestBody @Valid CourseForm courseForm) {
        ResultVO resultVO = new ResultVO();
        try {
            CourseEntity courseEntity = courseServiceImpl.addCourse(courseForm);
            resultVO = ResultVOUtil.success(courseEntity);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVOUtil.error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 主键删除课程
     *
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public ResultVO delete(@RequestBody @Valid String id) {
        ResultVO resultVO = new ResultVO();
        try {
            courseServiceImpl.delete(Long.parseLong(id));
            resultVO = ResultVOUtil.success("");
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVOUtil.error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 审核课程
     *
     * @param courseForm
     * @return
     */
    @PostMapping("/verify")
    public ResultVO verify(@RequestBody @Valid CourseForm courseForm) {
        ResultVO resultVO = new ResultVO();
        try {
            CoursePublishEntity courseEntity = courseServiceImpl.verifyCourse(courseForm);
            resultVO = ResultVOUtil.success(courseEntity);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVOUtil.error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 课程批量删除
     *
     * @param ids
     * @return
     */
    @PostMapping("/batch_delete")
    public ResultVO batchDelete(@RequestBody @Valid String ids) {
        ResultVO resultVO = new ResultVO();
        try {
            courseServiceImpl.batchDelete(ids);
            resultVO = ResultVOUtil.success("");
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVOUtil.error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 课程提交审核
     *
     * @param id
     * @return
     */
    @PostMapping("/action")
    public ResultVO action(@RequestBody @Valid String id) {
        ResultVO resultVO = new ResultVO();
        try {
            CoursePublishEntity coursePublishEntity = courseServiceImpl.saveCoursePublishById(Long.parseLong(id));
            resultVO = ResultVOUtil.success(coursePublishEntity);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVOUtil.error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 上传课程封面
     *
     * @param file
     * @return
     */
    @PostMapping("/album_up")
    public ResultVO albumUp(@RequestBody @Valid File file) {
        ResultVO resultVO = new ResultVO();
        try {
            String url = courseServiceImpl.uploadImg(file);
            resultVO = ResultVOUtil.success(url);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVOUtil.error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 获取课程详情
     *
     * @param id
     * @return
     */
    @GetMapping("/detail")
    public ResultVO detail(@RequestParam("id") String id) {
        ResultVO resultVO = new ResultVO();
        try {
            CoursePublishEntity course = courseServiceImpl.findCoursePublishEntityById(Long.parseLong(id));
            resultVO = ResultVOUtil.success(course);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVOUtil.error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 主键修改课程
     *
     * @param courseForm
     * @return
     */
    @PostMapping("/update")
    public ResultVO update(@RequestBody @Valid CourseForm courseForm) {
        ResultVO resultVO = new ResultVO();
        try {
            CourseEntity courseEntity = courseServiceImpl.updateCourse(courseForm);
            resultVO = ResultVOUtil.success(courseEntity);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVOUtil.error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }

    /**
     * 搜索参数获取课程资源
     * 分页查询所有用户（动态页数，每页大小，排序方式，排序字段）
     * 包括动态条件查询（属性值）
     * 规则：无输入条件，默认查询全部。默认返回第一页 每页5条，默认asc排序，默认id排序。
     *
     * @param paseSize
     * @param pageNo
     * @param name
     * @return
     */
    @GetMapping("/resources")
    public ResultWebVO<Page<CoursePublishEntity>> resources(
            @RequestParam("pase_size") String paseSize,
            @RequestParam("page_no") String pageNo,
            @RequestParam(value = "name", required = false) String name) {
        ResultWebVO resultVO = new ResultWebVO();
        try {
            Pages pages = new Pages();
            pages.setPageSize(Integer.parseInt(paseSize));
            pages.setPageNo(Integer.parseInt(pageNo));
            KeywordVO keywordVO = new KeywordVO();
            keywordVO.setKeywords(name);
            Page page = courseServiceImpl.findCourseAll(PagesUtils.createPageRequest(pages), keywordVO);
            PageVO pageVO = new PageVO();
            pageVO.setPaseSize(Integer.parseInt(paseSize));
            pageVO.setPageNo(Integer.parseInt(pageNo));
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
     * 资源名称修改
     * @param courseForm
     * @return
     */
    @PostMapping("/resources/update")
    public ResultVO resourcesUpdate(@RequestBody @Valid CourseForm courseForm) {
        ResultVO resultVO = new ResultVO();
        try {
            ResourceEntity resourceEntity = courseServiceImpl.updateResourceEntity(courseForm);
            resultVO = ResultVOUtil.success(resourceEntity);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVOUtil.error(ResultEnum.MANAGER_ERROR);
        }
        return resultVO;
    }
}
