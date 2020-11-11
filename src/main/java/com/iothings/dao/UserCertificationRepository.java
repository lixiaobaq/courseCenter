package com.iothings.dao;

import com.iothings.entity.UserCertificationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package： com.iothings.service
 * @author： ZDL
 * @date： 2020/11/10 09:55
 * @version： V1.0
 * @Description：  我的证书
 */
@Repository
public interface UserCertificationRepository extends JpaRepository<UserCertificationEntity,Long> {

    Page<UserCertificationEntity> findAll(Specification<UserCertificationEntity> specification, Pageable pageable);

}
