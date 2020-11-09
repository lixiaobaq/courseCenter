package com.iothings.controller;

import com.iothings.VO.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package： com.iothings.controller
 * @author： ZDL
 * @date： 2020/10/29 10:16
 * @version： V1.0
 * @Description：
 */
@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @GetMapping("list")
    public ResultVO list(){
        ResultVO resultVO = new ResultVO();

        return resultVO;
    }
}
