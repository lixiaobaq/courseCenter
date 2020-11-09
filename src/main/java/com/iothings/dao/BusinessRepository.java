package com.iothings.dao;

import com.iothings.entity.Business;
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

    List<Business> findByStatus(Integer status);

    List<Business> findByParentidAndStatus(Integer parentid, Integer status);
    /**
     * 获取行业分类下的所有课程数量
     * @param id
     * @return
     */
    @Query(value = "SELECT  COUNT(*) FROM `business` WHERE FIND_IN_SET( ?1, frame_id) ",nativeQuery = true)
    Integer findCourseNumByFrame(Integer id);

    /**
     * 修改课程分类排序
     * @param id
     * @param parentId
     * @param sort
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE business SET parentid=?2 ,sort=?3 WHERE id=?1",nativeQuery = true)
    Integer updataByid(Integer id,Integer parentId,Integer sort);
}
