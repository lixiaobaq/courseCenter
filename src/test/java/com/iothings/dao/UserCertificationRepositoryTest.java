package com.iothings.dao;

import com.iothings.util.Pages;
import com.iothings.entity.UserCertificationEntity;
import com.iothings.util.PagesUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.data.jpa.domain.Specification;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCertificationRepositoryTest {
    @Autowired
    private UserCertificationRepository repository;

    @Test
    public void findAllTest(){
        Pages pages = new Pages();
        pages.setPageNo(1);
        pages.setPageSize(10);
        Pageable pageable = PagesUtils.createPageRequest(pages);
        Specification<UserCertificationEntity> userCertificationEntity = null;
        Page<UserCertificationEntity> page = repository.findAll(userCertificationEntity, pageable);
        Assert.assertNotEquals(1,page.getTotalElements());
    }
}