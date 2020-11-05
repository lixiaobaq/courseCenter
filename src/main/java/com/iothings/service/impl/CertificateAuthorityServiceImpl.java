package com.iothings.service.impl;

import com.iothings.dao.CertificateAuthorityRepository;
import com.iothings.entity.CertificateAuthorityEntity;
import com.iothings.service.CertificateAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package： com.iothings.service.impl
 * @author： ZDL
 * @date： 2020/11/5 10:55
 * @version： V1.0
 * @Description： 证书机构
 */
@Service
public class CertificateAuthorityServiceImpl implements CertificateAuthorityService {

        @Autowired
        private CertificateAuthorityRepository certificateAuthorityRepository;

        @Override
        public List<CertificateAuthorityEntity> findCertificateAuthority() {
                List<CertificateAuthorityEntity> certificateAuthorityEntity = certificateAuthorityRepository.findCertificateAuthorityEntityBean();

                return certificateAuthorityEntity;
        }
}
