package com.iothings.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Guoyan
 */
@Entity
@Table(name = "course_catalog")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseCatalogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private Long id;
    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '课程id'")
    private Long courseId;
    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '层级'")
    private Long levelOf;
    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '序号'")
    private Long indexOf;
    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '父节点'")
    private Long parentId;
    @Column(nullable = true, columnDefinition = "varchar(200) COMMENT '图标'")
    private String icon;
    @Column(nullable = true, columnDefinition = "varchar(200) COMMENT '标题'")
    private String title;
    @Column(nullable = true, columnDefinition = "varchar(50) COMMENT '类型'")
    private String type;
    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '资源id'")
    private Long resourceId;
    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '任务id'")
    private Long taskId;
}
