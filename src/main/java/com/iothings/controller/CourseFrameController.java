package com.iothings.controller;

import com.iothings.VO.CourseFrameVO;
import com.iothings.VO.ResultVO;
import com.iothings.entity.CourseFrame;
import com.iothings.enums.CourseFrameType;
import com.iothings.enums.ResultEnum;
import com.iothings.service.impl.CourseFrameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.ResultVOUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author: GuoYan
 * @time:2020/10/29 8:00 PM
 * @Description：
 */
@RestController
@RequestMapping(name = "/api/style/")
public class CourseFrameController {
    @Autowired
    private CourseFrameServiceImpl courseFrameService;
    @GetMapping("list")
    public ResultVO list(){
        CourseFrameVO courseFrameVO=new CourseFrameVO();
        List<CourseFrame> courseFramelist=courseFrameService.getTree(CourseFrameType.DOWN_STATUS);
        courseFrameVO.setList(courseFramelist);
        return ResultVOUtil.success(Arrays.asList(courseFrameVO));
    }
}
