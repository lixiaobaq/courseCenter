package com.iothings.service.impl;

import com.iothings.dao.CertificationCenterRepository;
import com.iothings.dao.CourseRepository;
import com.iothings.entity.CertificationCenterEntity;
import com.iothings.entity.CourseEntity;
import com.iothings.service.CertificationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package： com.iothings.service.impl
 * @author： ZDL
 * @date： 2020/11/5 10:55
 * @version： V1.0
 * @Description： 证书表
 */
@Service
public class CertificationCenterServiceImpl implements CertificationCenterService {

        @Autowired
        private CertificationCenterRepository certificationCenterRepository;

        @Override
        public List<CertificationCenterEntity> findPopularCertificates() {
                List<CertificationCenterEntity> certificationCenterEntity = certificationCenterRepository.findCertificationCenterEntityBean();

                return certificationCenterEntity;
        }
}
