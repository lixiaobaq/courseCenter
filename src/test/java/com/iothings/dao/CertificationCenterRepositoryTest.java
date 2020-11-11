package com.iothings.dao;

import com.iothings.dto.CertificationCenterDTO;
import com.iothings.entity.CertificationCenterEntity;
import com.iothings.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CertificationCenterRepositoryTest {
    @Autowired
    private CertificationCenterRepository repository;

    /*@Test
    public void findOneTest(){
        CertificationCenterEntity certificationCenterEntity = repository.getOne(1);
        System.out.println(certificationCenterEntity.toString());
    }*/
   /* @Test
    @Transactional  //测试数据不进库
    public void saveTest(){
        CertificationCenterEntity certificationCenterEntity  = new CertificationCenterEntity("证书1111",34);
        CertificationCenterEntity result =repository.save(certificationCenterEntity);
        Assert.assertNotNull(result);
    }*/

    /*  @Test
      public void updateTest(){
          CertificationCenterEntity certificationCenterEntity = repository.getOne(1);
          certificationCenterEntity.setTitle("证书3");
          certificationCenterEntity.setCredit(10);
          repository.save(certificationCenterEntity);
      }
  */
    @Test
    public void findCertificationCenterBeanInTest(){
        List<CertificationCenterDTO> result=repository.findCertificationCenterEntityBean();
        Assert.assertNotEquals(0,result.size());
    }
}