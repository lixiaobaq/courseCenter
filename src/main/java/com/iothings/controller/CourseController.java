package com.iothings.controller;

import com.iothings.VO.HeadVO;
import com.iothings.VO.ProductVO;
import com.iothings.VO.ResultVO;
import com.iothings.entity.CourseEntity;
import com.iothings.entity.GraphicEntity;
import com.iothings.service.impl.CourseServiceImpl;
import com.iothings.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: GuoYan
 * @time:2020/10/29 8:00 PM
 * @Description：
 */
@RestController
@RequestMapping(name = "/api/course")
@Slf4j
public class CourseController {

    public ResultVOUtil resultVOUtil;

    public CourseServiceImpl courseServiceImpl;

    @GetMapping("list")
    public ResultVO list(@RequestParam("paseSize") Integer paseSize,
                         @RequestParam("pageNo") Integer pageNo,
                         @RequestParam("keywords") String keywords,
                         @RequestParam("keywordType") String keywordType,
                         @RequestParam("industry") Integer industry,
                         @RequestParam("verifyStatus") Integer verifyStatus,
                         @RequestParam("style_id") Integer style_id) {
        List<CourseEntity> course = courseServiceImpl.findAll(paseSize, pageNo, keywords, keywordType, industry, verifyStatus);
        ProductVO productVO = new ProductVO();
        productVO.setDataList(course);
        ResultVO resultVO = resultVOUtil.success(productVO);
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
