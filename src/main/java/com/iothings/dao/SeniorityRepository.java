package com.iothings.dao;

import com.iothings.entity.Business;
import com.iothings.entity.Seniority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/7 14:51
 * @Description
 */
public interface SeniorityRepository extends JpaRepository<Seniority,Long> {
    List<Seniority> findByParentId(Integer pid);

    List<Seniority> findByStatus(Integer status);

    List<Seniority> findByParentIdAndStatus(Integer parentId,Integer status);
}
