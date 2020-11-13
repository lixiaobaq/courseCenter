package com.iothings.service;

import com.iothings.dto.CertificationCenterDTO;
import com.iothings.entity.CertificationCenterEntity;
import com.iothings.entity.UserCertificationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Package： com.iothings.service
 * @author： ZDL
 * @date： 2020/11/10 09:55
 * @version： V1.0
 * @Description： 我的证书
 */
public interface UserCertificationService {

        /**
         * 列表
         * @return
         */
        Page<UserCertificationEntity> findAll(UserCertificationEntity userCertificationEntity, Pageable pageable);
        
        
        

}
