package com.iothings.service.impl;

import com.iothings.dto.CertificationCenterDTO;
import com.iothings.entity.UserCertificationEntity;
import com.iothings.util.Pages;
import com.iothings.util.PagesUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCertificationServiceImplTest {

    @Autowired
    private UserCertificationServiceImpl userCertificationServiceImpl;

    @Test
    public void findAllImplTest() {
        Pages pages = new Pages();
        pages.setPageNo(1);
        pages.setPageSize(10);
        Pageable pageable = PagesUtils.createPageRequest(pages);
        UserCertificationEntity userCertificationEntity = new UserCertificationEntity();
        Page page = userCertificationServiceImpl.findAll(userCertificationEntity,pageable);
        Assert.assertNotEquals(0,page.getTotalElements());
    }
}