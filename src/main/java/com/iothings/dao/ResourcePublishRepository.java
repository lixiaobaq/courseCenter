package com.iothings.dao;

import com.iothings.entity.ResourceEntity;
import com.iothings.entity.ResourcePublishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Huanglei
 * @time:2020/10/28 10:18 AM
 * @Description：
 */
public interface ResourcePublishRepository extends JpaRepository<ResourcePublishEntity, Long> {

}
