package com.iothings.service.impl;

import com.iothings.dao.CertificationCenterRepository;
import com.iothings.dto.CertificationCenterDTO;
import com.iothings.entity.CertificationCenterEntity;
import com.iothings.service.CertificationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        /**
         * 列表
         * @return
         */
        @Override
        public List<CertificationCenterDTO> findPopularCertificates() {
                List<CertificationCenterDTO> certificationCenterDTO = certificationCenterRepository.findCertificationCenterEntityBean();

                return certificationCenterDTO;
        }

        /**
         * 添加
         * @param certificationCenterEntity
         * @return
         */
        @Override
        public CertificationCenterEntity save(CertificationCenterEntity certificationCenterEntity) {
                return certificationCenterRepository.save(certificationCenterEntity);
        }

        /**
         * 删除
         * @param id
         */
        @Override
        public void delete(Integer id){
                certificationCenterRepository.deleteById(Long.valueOf(id));
        }

        /**
         * 判断根据ID能否查到数据
         * @param id
         * @return
         */
        @Override
        public boolean existsById(Integer id){
                return certificationCenterRepository.existsById(Long.valueOf(id));
        }
}
