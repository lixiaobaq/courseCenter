package com.iothings.dao;

import com.iothings.entity.CourseCatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseCatalogRepository extends JpaRepository<CourseCatalogEntity,Long> {

}