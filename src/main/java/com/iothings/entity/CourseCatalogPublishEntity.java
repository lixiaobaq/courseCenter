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
    @Column(nullable = true, columnDefinition = "bigint COMMENT '课程id'")
    private Long courseId;
    @Column(nullable = true, columnDefinition = "bigint COMMENT '层级'")
    private Long levelOf;
    @Column(nullable = true, columnDefinition = "bigint COMMENT '序号'")
    private Long indexOf;
    @Column(nullable = true, columnDefinition = "bigint COMMENT '父节点'")
    private Long parentId;
    @Column(nullable = true, columnDefinition = "varchar COMMENT '图标'")
    private String icon;
    @Column(nullable = true, columnDefinition = "varchar COMMENT '标题'")
    private String title;
    @Column(nullable = true, columnDefinition = "varchar COMMENT '类型'")
    private String type;
    @Column(nullable = true, columnDefinition = "bigint COMMENT '资源id'")
    private Long resourceId;
    @Column(nullable = true, columnDefinition = "bigint COMMENT '任务id'")
    private Long taskId;
}
