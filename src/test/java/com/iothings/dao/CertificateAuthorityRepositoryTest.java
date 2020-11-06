package com.iothings.dao;

import com.iothings.entity.CertificateAuthorityEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CertificateAuthorityRepositoryTest {
    @Autowired
    private CertificateAuthorityRepository repository;


    @Test
    public void findCertificationCenterBeanInTest(){
        List<CertificateAuthorityEntity> result=repository.findCertificateAuthorityEntityBean();
        Assert.assertNotEquals(0,result.size());
    }
}