package com.iothings.controller;

import com.iothings.VO.HeadVO;
import com.iothings.VO.ResultVO;
import com.iothings.entity.CourseEntity;
import com.iothings.entity.GraphicEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: GuoYan
 * @time:2020/10/29 8:00 PM
 * @Description：
 */
@RestController
@RequestMapping(name = "course")
public class CourseController {

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

    @PostMapping("createCouse")
    public ResultVO createCouse(@RequestParam("course") CourseEntity course){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }

    @GetMapping("getCouseListBy")
    public ResultVO getCouseListBy(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }

    @GetMapping("getCouseInfo")
    public ResultVO getCouseInfo(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }

    @PostMapping("deleteCouses")
    public ResultVO deleteCouses(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }

    @PostMapping("submitCourse")
    public ResultVO submitCourse(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }

    @PostMapping("saveCouseCatalogTree")
    public ResultVO saveCouseCatalogTree(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }

    @PostMapping("inspectCourse")
    public ResultVO inspectCourse(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }

    @PostMapping("publishCourse")
    public ResultVO publishCourse(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }

    @PostMapping("playResource")
    public ResultVO playResource(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }

    @PostMapping("callTest")
    public ResultVO callTest(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }

    @PostMapping("uploadResource")
    public ResultVO uploadResource(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }

    @GetMapping("getResourceList")
    public ResultVO getResourceList(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }

    @PostMapping("deleteResources")
    public ResultVO deleteResources(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }
}
