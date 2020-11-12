package com.iothings.controller;

import com.iothings.VO.ResultWebVO;
import com.iothings.dto.CertificationCenterDTO;
import com.iothings.entity.CertificationCenterEntity;
import com.iothings.enums.ResultEnum;
import com.iothings.form.PopularCertificatesForm;
import com.iothings.service.CertificationCenterService;
import com.iothings.service.impl.CertificationCenterServiceImpl;
import com.iothings.util.ResultWebVOUtil;
import com.iothings.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private CertificationCenterService certificationCenterService;
    /**
     * 热门证书
     * @return
     */
    @PostMapping("popularCertificates")
    public ResultWebVO list(){
        ResultWebVO resultWebVO = new ResultWebVO();

        List<CertificationCenterDTO> list = certificationCenterService.findPopularCertificates();
      //List<CertificationCenterEntity> list1 = certificationCenterService.findCertificates();
        resultWebVO = ResultWebVOUtil.success(list);
        return resultWebVO;
    }


    //** Admin Start
    /**
     * 添加认证
     * @param popularCertificatesForm
     * @return
     */
    @PostMapping("createCertificates")
    public ResultWebVO createCertificates(PopularCertificatesForm popularCertificatesForm){
        ResultWebVO resultWebVO = new ResultWebVO();
        if(popularCertificatesForm != null){
            CertificationCenterEntity certificationCenterEntity = new CertificationCenterEntity();
            BeanUtils.copyProperties(popularCertificatesForm,certificationCenterEntity);
            CertificationCenterEntity c = certificationCenterService.save(certificationCenterEntity);
            resultWebVO = ResultWebVOUtil.success(c);
        }else{
            resultWebVO = ResultWebVOUtil.save_error(ResultEnum.PARAM_ERROR.getMessage());
        }
        return resultWebVO;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("delCertificates")
    public ResultWebVO delCertificates(@RequestParam("id") String id){
        ResultWebVO resultWebVO = new ResultWebVO();

        if(StringUtil.isNotEmpty(id)){
            //先根据ID查询数据是否持久化 后在删除
            if(certificationCenterService.existsById(Integer.parseInt(id))){
                certificationCenterService.delete(Integer.parseInt(id));
                resultWebVO = ResultWebVOUtil.success(ResultEnum.DELETE_SUCCES.getMessage());
            }else{
                resultWebVO = ResultWebVOUtil.success(ResultEnum.EXISTS_ERROR.getMessage());
            }
        }else{
            resultWebVO = ResultWebVOUtil.save_error(ResultEnum.PARAM_ERROR.getMessage());
        }
        return resultWebVO;
    }


    //** Admin End
}
