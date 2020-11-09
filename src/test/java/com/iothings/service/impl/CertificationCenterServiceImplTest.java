package com.iothings.service.impl;

import com.iothings.dto.CertificationCenterDTO;
import com.iothings.entity.CertificationCenterEntity;
import com.iothings.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CertificationCenterServiceImplTest {

    @Autowired
    private CertificationCenterServiceImpl certificationCenterServiceImpl;

    @Test
    public void findByCategoryTypeIn() {
        List<CertificationCenterDTO> certificationCenterEntity=certificationCenterServiceImpl.findPopularCertificates();
        Assert.assertNotEquals(0,certificationCenterEntity.size());
    }
}