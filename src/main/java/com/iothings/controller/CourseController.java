package com.iothings.controller;

import com.iothings.VO.HeadVO;
import com.iothings.VO.PageVO;
import com.iothings.VO.ResultVO;
import com.iothings.entity.CoursePublishEntity;
import com.iothings.entity.GraphicEntity;
import com.iothings.enums.ResultEnum;
import com.iothings.service.impl.CourseServiceImpl;
import com.iothings.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
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

    @GetMapping("/list")
    public ResultVO list(@RequestParam("paseSize") String paseSize,
                         @RequestParam("pageNo") String pageNo,
                         @RequestParam(value = "keywords", required =  false) String keywords,
                         @RequestParam(value = "keywordType", required =  false) String keywordType,
                         @RequestParam(value = "industry", required =  false) Integer industry,
                         @RequestParam(value = "verifyStatus", required =  false) Integer verifyStatus,
                         @RequestParam(value = "style_id", required =  false) Integer style_id) {
        ResultVO resultVO = new ResultVO();
        try {
            List<CoursePublishEntity> course = courseServiceImpl.findAll(Integer.parseInt(paseSize), Integer.parseInt(pageNo), keywords, keywordType, industry, verifyStatus);
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

    @GetMapping("head")
    public ResultVO head() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        HeadVO headVO = new HeadVO();

        GraphicEntity graphicEntity = new GraphicEntity();
        graphicEntity.setId(1l);
        graphicEntity.setImageUrl("http://www.baidu.com");
        graphicEntity.setUrl("http://www.baidu.com");
        graphicEntity.setTitle("Logo");
        headVO.setLogo(graphicEntity);
        headVO.setNavis(null);
        resultVO.setData(headVO);

        return resultVO;

    }

}
