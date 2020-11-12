package com.iothings.service.impl;

import com.iothings.VO.KeywordVO;
import com.iothings.dao.CoursePublishRepository;
import com.iothings.dao.CourseRepository;
import com.iothings.dao.ResourceRepository;
import com.iothings.entity.CourseEntity;
import com.iothings.entity.CoursePublishEntity;
import com.iothings.entity.ResourceEntity;
import com.iothings.entity.UserCertificationEntity;
import com.iothings.enums.CourseKeywordTypeEnum;
import com.iothings.enums.CoursePublishEnum;
import com.iothings.exception.UnsupportedFileTypeException;
import com.iothings.form.CourseForm;
import com.iothings.service.CourseService;
import com.iothings.util.FileUtils;

import com.iothings.util.Pages;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.xml.bind.PropertyException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CoursePublishRepository coursePublishRepository;
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public Page<CoursePublishEntity> findCourseAll(Pageable pageable, KeywordVO keywordVO) {
        Page<CoursePublishEntity> page = coursePublishRepository.findAll((Root<CoursePublishEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();

            if (null != keywordVO.getKeywordType() && !"".equals(keywordVO.getKeywordType())) {
                switch (CourseKeywordTypeEnum.getByType(keywordVO.getKeywordType())) {
                    case NAME:
                        predicates.add(cb.like(root.get("title").as(String.class), "%" + keywordVO.getKeywords() + "%"));
                        predicates.add(cb.like(root.get("subTitle").as(String.class), "%" + keywordVO.getKeywords() + "%"));
                        break;
                    case ID:
                        predicates.add(cb.equal(root.get("id").as(String.class), keywordVO.getKeywords()));
                        break;
                    case USER:
                        predicates.add(cb.equal(root.get("createrId").as(String.class), keywordVO.getKeywords()));
                        break;
                    case ORGAN:
                        predicates.add(cb.equal(root.get("organ").as(String.class), keywordVO.getKeywords()));
                        break;
                }
            } else {
                predicates.add(cb.like(root.get("title").as(String.class), "%" + keywordVO.getKeywords() + "%"));
                predicates.add(cb.like(root.get("subTitle").as(String.class), "%" + keywordVO.getKeywords() + "%"));
            }

            if (null != keywordVO.getStyleId() && !"".equals(keywordVO.getStyleId())) {
                predicates.add(cb.like(root.get("frameId").as(String.class), "%" + keywordVO.getStyleId() + "%"));
            }
            if (null != keywordVO.getVerifyStatus() && !"".equals(keywordVO.getVerifyStatus())) {
                predicates.add(cb.equal(root.get("status").as(String.class), keywordVO.getVerifyStatus()));
            }
            if (null != keywordVO.getIndustry() && !"".equals(keywordVO.getIndustry())) {
                predicates.add(cb.equal(root.get("industry").as(String.class), keywordVO.getIndustry()));
            }
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//            try {
//                if (null != keywordVO.getCreateTimeStart() && !"".equals(keywordVO.getCreateTimeStart()))
//                    predicates.add(cb.greaterThanOrEqualTo(root.get("createTime").as(Date.class),f.parse(keywordVO.getCreateTimeStart())));
//                if (null != keywordVO.getCreateTimeEnd() && !"".equals(keywordVO.getCreateTimeEnd()))
//                    predicates.add(cb.lessThan(root.get("createTime").as(Date.class),new Date(f.parse(keywordVO.getCreateTimeEnd()).getTime() + 24 * 3600 * 1000)));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        }, pageable);
        return page;
    }

    @Override
    public CourseEntity addCourse(CourseForm courseForm) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setTitle(courseForm.getTitle());
        courseEntity.setSubTitle(courseForm.getSubTitle());
        courseEntity.setFrameId(courseForm.getStyleId());
        courseEntity.setTitlePageUrls(courseForm.getImages());
        courseEntity.setSummary(courseForm.getContent());
        courseEntity.setIndustry(Long.parseLong(courseForm.getIndustry()));
        return courseRepository.save(courseEntity);
    }

    @Override
    public boolean delete(Long id) {
        boolean result = true;
        try {
            coursePublishRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    @Override
    public CoursePublishEntity verifyCourse(CourseForm courseForm) {
        CoursePublishEntity courseEntity = new CoursePublishEntity();
        if (null != courseForm.getId()) {
            courseEntity = coursePublishRepository.getOne(Long.parseLong(courseForm.getId()));
        }
        courseEntity.setStatus(courseForm.getVerifyStatus());
        if (CoursePublishEnum.PASS.getCode().equals(courseForm.getVerifyStatus())) {
            courseEntity.setFrameId(courseForm.getReason());
            courseEntity.setPrice(new BigDecimal(courseForm.getPrice()));
        }
        return coursePublishRepository.save(courseEntity);
    }

    @Override
    public boolean batchDelete(String ids) {
        boolean result = true;
        if (ids.contains(",")) {
            String[] list = ids.split(",");
            for (String id : list) {
                try {
                    coursePublishRepository.deleteById(Long.parseLong(id));
                } catch (Exception e) {
                    e.printStackTrace();
                    result = false;
                }
            }
        } else {
            try {
                coursePublishRepository.deleteById(Long.parseLong(ids));
            } catch (Exception e) {
                e.printStackTrace();
                result = false;
            }
        }
        return result;
    }

    @Override
    public CoursePublishEntity saveCoursePublishById(Long id) {
        CourseEntity courseEntity = courseRepository.getOne(id);
        CoursePublishEntity coursePublishEntity = new CoursePublishEntity();
        BeanUtils.copyProperties(courseEntity, coursePublishEntity);
        coursePublishEntity.setVersionNumber("1.0.1");
        coursePublishEntity.setSubmitterId(1l);
        coursePublishEntity.setId(null);
        coursePublishEntity.setCourseId(id);
        coursePublishEntity.setStatus(CoursePublishEnum.NEW.getCode());
        return coursePublishRepository.save(coursePublishEntity);
    }

    @Override
    public String uploadImg(File file) throws UnsupportedFileTypeException, IOException, PropertyException {
        FileItem fileItem = createFileItem(file);
        MultipartFile mfile = new CommonsMultipartFile(fileItem);
        String url = FileUtils.saveFile(mfile);
        return url;
    }

    @Override
    public CoursePublishEntity findCoursePublishEntityById(Long id) {
        return coursePublishRepository.getOne(id);
    }

    @Override
    public CourseEntity updateCourse(CourseForm courseForm) {
        CourseEntity course = new CourseEntity();
        if (null != courseForm.getId()) {
            course = courseRepository.getOne(Long.parseLong(courseForm.getId()));
        }
        course.setTitle(courseForm.getTitle());
        course.setSubTitle(courseForm.getSubTitle());
        course.setFrameId(courseForm.getStyleId());
        course.setTitlePageUrls(courseForm.getImages());
        course.setSummary(courseForm.getDesc());
        course.setIndustry(Long.parseLong(courseForm.getIndustry()));
        return courseRepository.save(course);
    }

    @Override
    public ResourceEntity updateResourceEntity(CourseForm courseForm) {
        ResourceEntity resourceEntity = new ResourceEntity();
        if (null != courseForm.getId()) {
            resourceEntity = resourceRepository.getOne(Long.parseLong(courseForm.getId()));
        }
        resourceEntity.setName(courseForm.getName());
        return resourceRepository.save(resourceEntity);
    }

    private FileItem createFileItem(File file) {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        FileItem item = factory.createItem("", "text/plain", true, file.getName());
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        try {
            FileInputStream fis = new FileInputStream(file);
            OutputStream os = item.getOutputStream();
            while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;

    }
}
