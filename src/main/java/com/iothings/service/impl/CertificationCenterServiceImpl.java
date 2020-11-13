package com.iothings.service.impl;

import com.iothings.dao.CertificationCenterRepository;
import com.iothings.dto.CertificationCenterDTO;
import com.iothings.entity.CertificateAuthorityEntity;
import com.iothings.entity.CertificationCenterEntity;
import com.iothings.service.CertificationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
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
         * 用Specification作的多表查询，但未出来，暂时弃用
         * @return
         */
        @Override
        public List<CertificationCenterEntity> findCertificates() {
                List<Predicate> certificationCenterDTO = new ArrayList<Predicate>();
                Specification<CertificationCenterEntity> spec = new Specification<CertificationCenterEntity>() {
                        public Predicate toPredicate(Root<CertificationCenterEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                                //Join代表链接查询，通过root对象获取
                                //创建的过程中，第一个参数为关联对象的属性名称，第二个参数为连接查询的方式（left，inner，right）
                                //JoinType.LEFT : 左外连接,JoinType.INNER：内连接,JoinType.RIGHT：右外连接
                            //   Join<CertificationCenterEntity, CertificateAuthorityEntity> join = root.join("certifications", JoinType.LEFT);
                            //   certificationCenterDTO.add(cb.equal(join.get("id"),1));
                             //   certificationCenterDTO.add(cb.like(root.get("title").as(String.class), "%证书%"));
                                //返回
                              //  return cb.and(certificationCenterDTO.toArray(new Predicate[certificationCenterDTO.size()]));
                             //   return cb.equal(join.get("certificateAuthorityEntity").as(String.class),"1");
                             //   return query.where(certificationCenterDTO.toArray(new Predicate[certificationCenterDTO.size()])).getRestriction();
                                Join<CertificationCenterEntity, CertificateAuthorityEntity> join = root.join("certificateAuthorityEntity",JoinType.LEFT);
                              //  return cb.like(join.get("id").as(String.class),"%1%");
                                return cb.and(certificationCenterDTO.toArray(new Predicate[certificationCenterDTO.size()]));
                        }
                };
                List<CertificationCenterEntity> list = certificationCenterRepository.findAll(spec);
               /* for (CertificationCenterEntity linkMan : list) {
                        System.out.println(linkMan);
                }*/
                return list;

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
