package com.iothings.dao;


import com.iothings.entity.CertificationCenterEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package： com.iothings.service
 * @author： ZDL
 * @date： 2020/11/5 10:55
 * @version： V1.0
 * @Description： 证书关联查询
 */
@Repository
public interface CertificationRepository extends JpaSpecificationExecutor<CertificationCenterEntity> {


}
