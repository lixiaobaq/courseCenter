package com.iothings.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Guoyan
 */
@Entity
@Table(name = "course_catalog_publish")
@Data
public class CourseCatalogPublishEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long courseId;
    //层级
    private Long levelOf;
    //序号
    private Long indexOf;
    //父节点
    private Long parentId;
    private String icon;
    private String title;
    //0资源 1任务
    private String type;
    private Long resourceId;
    private Long taskId;
}
