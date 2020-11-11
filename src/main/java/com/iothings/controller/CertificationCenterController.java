package com.iothings.controller;

import com.iothings.VO.ResultWebVO;
import com.iothings.dto.CertificationCenterDTO;
import com.iothings.entity.CertificationCenterEntity;
import com.iothings.service.impl.CertificationCenterServiceImpl;
import com.iothings.util.ResultWebVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Package： com.iothings.controller
 * @author： ZDL
 * @date： 2020/11/5 10:48
 * @version： V1.0
 * @Description：
 */
@RestController
@RequestMapping("/api/")
public class CertificationCenterController {

    @Autowired
    private CertificationCenterServiceImpl certificationCenterServiceImpl;
    /**
     * 热门证书
     * @return
     */
    @PostMapping("popularCertificates")
    public ResultWebVO list(){
        ResultWebVO resultWebVO = new ResultWebVO();

        List<CertificationCenterDTO> list = certificationCenterServiceImpl.findPopularCertificates();
        resultWebVO = ResultWebVOUtil.success(list);
        return resultWebVO;
    }


    //** Admin Start


    //** Admin End
}
