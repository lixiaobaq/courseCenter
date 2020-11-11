package com.iothings.dao;

import com.iothings.entity.Business;
import com.iothings.entity.CourseFrame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/6 11:24
 * @Description
 */
public interface BusinessRepository  extends JpaRepository<Business,Long> {
    List<Business> findByParentId(Integer pid);

    List<Business> findByStatus(Integer status);

    List<Business> findByParentIdAndStatus(Integer parentId,Integer status);
}
