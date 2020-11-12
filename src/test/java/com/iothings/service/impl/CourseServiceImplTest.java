package com.iothings.service.impl;

import com.iothings.VO.KeywordVO;
import com.iothings.entity.CourseEntity;
import com.iothings.entity.CoursePublishEntity;
import com.iothings.entity.ResourceEntity;
import com.iothings.exception.UnsupportedFileTypeException;
import com.iothings.form.CourseForm;
import com.iothings.util.Pages;
import com.iothings.util.PagesUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.PropertyException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImplTest {

    @Autowired
    private CourseServiceImpl courseService;

    @Test
    public void findCourseAll() {
        Pages pages = new Pages();
        pages.setPageSize(10);
        pages.setPageNo(0);
        KeywordVO keywordVO = new KeywordVO();
        keywordVO.setKeywords("on_project");
        keywordVO.setKeywordType("1");
        keywordVO.setIndustry("1");
        keywordVO.setVerifyStatus("1");
        keywordVO.setStyleId("1");
        Page page = courseService.findCourseAll(PagesUtils.createPageRequest(pages), keywordVO);
        Assert.assertEquals(new ArrayList<CoursePublishEntity>(), page.getContent());
    }

    @Test
    @Transactional
    public void addCourse() {
        CourseForm courseForm = new CourseForm();
        courseForm.setTitle("on_project");
        courseForm.setSubTitle("on_project");
        courseForm.setStyleId("1");
        courseForm.setImages("on_project");
        courseForm.setContent("on_project");
        courseForm.setIndustry("1");
        CourseEntity courseEntity = courseService.addCourse(courseForm);
        Assert.assertNotNull(courseEntity);
    }

    @Test
    @Transactional
    public void verifyCourse() {
        CourseForm courseForm = new CourseForm();
        courseForm.setId("1");
        courseForm.setVerifyStatus("1");
        courseForm.setReason("1,2,3");
        courseForm.setPrice("99.00");
        CoursePublishEntity courseEntity = courseService.verifyCourse(courseForm);
        Assert.assertNotNull(courseEntity);
    }

    @Test
    @Transactional
    public void saveCoursePublishById() {
        CoursePublishEntity courseEntity = courseService.saveCoursePublishById(1l);
        Assert.assertNotNull(courseEntity);
    }

    @Test
    @Transactional
    public void deleteCoursePublishEntity() {
        boolean result = courseService.delete(1l);
        Assert.assertTrue(result);
    }

    @Test
    @Transactional
    public void batchDelete() {
        boolean result = courseService.batchDelete("1,2,3");
        Assert.assertTrue(result);
    }

    @Test
    @Transactional
    public void uploadImg() throws UnsupportedFileTypeException, IOException, PropertyException {
        File file = new File("E:\\upload\\img202010271454335181628.jpg");
        String url = courseService.uploadImg(file);
        Assert.assertNotNull(url);
    }

    @Test
    @Transactional
    public void findCoursePublishEntityById(){
        CoursePublishEntity coursePublishEntity = courseService.findCoursePublishEntityById(1l);
        Assert.assertNotNull(coursePublishEntity);
    }

    @Test
    @Transactional
    public void updateCourse() {
        CourseForm courseForm = new CourseForm();
        courseForm.setId("1");
        courseForm.setTitle("on_project");
        courseForm.setSubTitle("on_project");
        courseForm.setStyleId("1,2,3");
        courseForm.setImages("on_project");
        courseForm.setDesc("on_project");
        courseForm.setIndustry("1");
        CourseEntity courseEntity = courseService.updateCourse(courseForm);
        Assert.assertNotNull(courseEntity);
    }

    @Test
    public void resources() {
        Pages pages = new Pages();
        pages.setPageSize(10);
        pages.setPageNo(0);
        KeywordVO keywordVO = new KeywordVO();
        keywordVO.setKeywords("on_project");
        Page page = courseService.findCourseAll(PagesUtils.createPageRequest(pages), keywordVO);
        Assert.assertEquals(new ArrayList<CoursePublishEntity>(), page.getContent());
    }

    @Test
    @Transactional
    public void resourcesUpdate() {
        CourseForm courseForm = new CourseForm();
        courseForm.setId("1");
        courseForm.setName("on_project");
        ResourceEntity resourceEntity = courseService.updateResourceEntity(courseForm);
        Assert.assertNotNull(resourceEntity);
    }
}
