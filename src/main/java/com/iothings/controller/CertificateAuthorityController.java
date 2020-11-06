package com.iothings.controller;

import com.iothings.VO.ResultWebVO;
import com.iothings.entity.CertificateAuthorityEntity;
import com.iothings.entity.CertificationCenterEntity;
import com.iothings.service.impl.CertificateAuthorityServiceImpl;
import com.iothings.util.ResultWebVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CertificateAuthorityController {

    @Autowired
    private CertificateAuthorityServiceImpl certificateAuthorityServiceImpl;
    /**
     * 证书机构
     * @return
     */
    @PostMapping("certificateOrganization")
    public ResultWebVO list(){
        ResultWebVO resultWebVO = new ResultWebVO();

        List<CertificateAuthorityEntity> list = certificateAuthorityServiceImpl.findCertificateAuthority();
        resultWebVO = ResultWebVOUtil.success(list);
        return resultWebVO;
    }
}
