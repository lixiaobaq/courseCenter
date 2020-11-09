package com.iothings.service;

import com.iothings.dto.CertificationCenterDTO;
import com.iothings.entity.CertificationCenterEntity;
import com.iothings.entity.CourseFrame;

import java.util.List;

/**
 * @Package： com.iothings.service
 * @author： ZDL
 * @date： 2020/11/5 10:55
 * @version： V1.0
 * @Description： 证书表
 */
public interface CertificationCenterService {

        /**
         * 列表
         * @return
         */
        List<CertificationCenterDTO> findPopularCertificates();

        /**
         * 添加
         * @param certificationCenterEntity
         * @return
         */
        CertificationCenterEntity save(CertificationCenterEntity certificationCenterEntity);

        /**
         * 删除
         * @param id
         */
        void delete(Integer id);


        boolean existsById(Integer id);

}
