package com.iothings.controller;

import com.iothings.VO.HeadVO;
import com.iothings.VO.ProductVO;
import com.iothings.VO.ResultVO;
import com.iothings.entity.GraphicEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author: Huanglei
 * @time:2020/10/27 9:24 PM
 * @Description：
 */
@RestController
@RequestMapping("/buyer/product")
public class ProductController {

    @GetMapping("list")
    public ResultVO list(){
        ResultVO resultVO=new ResultVO();


        resultVO.setCode(0);
        resultVO.setMsg("成功");



        ProductVO productVO=new ProductVO();
        productVO.setCategoryName("课程");
        productVO.setCategoryType(1);

        ProductVO productVO1=new ProductVO();
        productVO1.setCategoryName("证书");
        productVO.setCategoryType(2);
        resultVO.setData(Arrays.asList(productVO,productVO1));
        return resultVO;
    }

    @GetMapping("head")
    public ResultVO head(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        HeadVO headVO=new HeadVO();

        GraphicEntity graphicEntity=new GraphicEntity();
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
