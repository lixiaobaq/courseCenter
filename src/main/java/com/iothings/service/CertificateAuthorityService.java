package com.iothings.service;

import com.iothings.entity.CertificateAuthorityEntity;
import com.iothings.entity.CertificationCenterEntity;

import java.util.List;

/**
 * @Package： com.iothings.service
 * @author： ZDL
 * @date： 2020/11/5 10:55
 * @version： V1.0
 * @Description： 证书机构
 */
public interface CertificateAuthorityService {

        List<CertificateAuthorityEntity> findCertificateAuthority();
}
