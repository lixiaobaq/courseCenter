package com.iothings.dao;

import com.iothings.entity.CertificationCenterEntity;
import com.iothings.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Package： com.iothings.service
 * @author： ZDL
 * @date： 2020/11/5 10:55
 * @version： V1.0
 * @Description： 证书表
 */
public interface CertificationCenterRepository extends JpaRepository<CertificationCenterEntity,Long> {

    @Query(value = "SELECT * FROM popular_certificates WHERE 1=1", nativeQuery=true)
    List<CertificationCenterEntity> findCertificationCenterEntityBean();

}
