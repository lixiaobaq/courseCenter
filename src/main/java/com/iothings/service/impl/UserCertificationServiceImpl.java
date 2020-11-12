package com.iothings.service.impl;

import com.iothings.dao.UserCertificationRepository;
import com.iothings.entity.UserCertificationEntity;
import com.iothings.service.UserCertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package： com.iothings.service.impl
 * @author： ZDL
 * @date： 2020/11/5 10:55
 * @version： V1.0
 * @Description： 我的证书
 */
@Service
public class UserCertificationServiceImpl implements UserCertificationService {

    @Autowired
    private UserCertificationRepository userCertificationRepository;

    /**
     * 证书列表
     *
     * @return
     */
    @Override
    public Page<UserCertificationEntity> findAll(UserCertificationEntity userCertificationEntity, Pageable pageable) {

        Page<UserCertificationEntity> page = userCertificationRepository.findAll((Root<UserCertificationEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();

           /* predicates.add(cb.like(root.get("userName").as(String.class), "%" + userCertificationEntity.getUserName() + "%"));
            predicates.add(cb.like(root.get("email").as(String.class), "%" + userCertificationEntity.getEmail() + "%"));
            predicates.add(cb.like(root.get("phoneNo").as(String.class), "%" + userCertificationEntity.getPhoneNo() + "%"));
            predicates.add(cb.equal(root.get("isValid").as(String.class), userCertificationEntity.getIsValid()));

            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");*/
          /*  try {
                if (null != userCertificationEntity.getCreateTimeStart() && !"".equals(userCertificationEntity.getCreateTimeStart()))
                    predicates.add(cb.greaterThanOrEqualTo(root.get("createTime").as(Date.class),f.parse(userCertificationEntity.getCreateTimeStart())));
                if (null != userCertificationEntity.getCreateTimeEnd() && !"".equals(userCertificationEntity.getCreateTimeEnd()))
                    predicates.add(cb.lessThan(root.get("createTime").as(Date.class),new Date(f.parse(userCertificationEntity.getCreateTimeEnd()).getTime() + 24 * 3600 * 1000)));
            } catch (ParseException e) {
                e.printStackTrace();
            }*/
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        }, pageable);
        return page;


    }

}
