package com.iothings.dao;

import com.iothings.dto.CertificationCenterDTO;
import com.iothings.entity.CertificationCenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package： com.iothings.service
 * @author： ZDL
 * @date： 2020/11/5 10:55
 * @version： V1.0
 * @Description： 证书表
 */
@Repository
public interface CertificationCenterRepository extends JpaRepository<CertificationCenterEntity,Long>, JpaSpecificationExecutor<CertificationCenterEntity> {

    @Query(value = "SELECT pc.id,gi.img_url img,pc.title title,ar.title authentication,pc.credit credit,GROUP_CONCAT(c.title separator ',') course FROM certificates pc LEFT JOIN authority ar on pc.authentication_id = ar.id LEFT JOIN group_img gi on pc.group_img_id = gi.id and gi.is_cover='1' LEFT JOIN course c on FIND_IN_SET(c.id,pc.course_id) WHERE 1=1 ", nativeQuery=true)
    List<CertificationCenterDTO> findCertificationCenterEntityBean();
}
