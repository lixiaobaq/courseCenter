package com.iothings.service.impl;

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
public class CertificateAuthorityServiceImplTest {

    @Autowired
    private CertificateAuthorityServiceImpl certificateAuthorityServiceImpl;

    @Test
    public void findByCategoryTypeIn() {
        List<CertificateAuthorityEntity> certificationCenterEntity=certificateAuthorityServiceImpl.findCertificateAuthority();
        Assert.assertNotEquals(0,certificationCenterEntity.size());
    }
}