package com.iothings.dao;

import com.iothings.entity.CertificateAuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Package： com.iothings.service
 * @author： ZDL
 * @date： 2020/11/5 10:55
 * @version： V1.0
 * @Description： 证书机构
 */
public interface CertificateAuthorityRepository extends JpaRepository<CertificateAuthorityEntity,Long> {

    @Query(value = "SELECT * FROM authority WHERE 1=1", nativeQuery=true)
    List<CertificateAuthorityEntity> findCertificateAuthorityEntityBean();

}
