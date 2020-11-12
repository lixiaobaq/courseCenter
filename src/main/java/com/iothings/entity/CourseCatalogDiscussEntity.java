package com.iothings.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "course_catalog_discuss")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseCatalogDiscussEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '课程目录id'")
    private Long courseCatalogId;
    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '用户id'")
    private Long userId;
    @Column(nullable = true, columnDefinition = "varchar(20) COMMENT '账号'")
    private String username;
    @Column(updatable = false, nullable = true, columnDefinition = "datetime COMMENT '评论时间'")
    @CreationTimestamp
    private Date time;
    @Column(nullable = true, columnDefinition = "varchar(5) COMMENT '赞'")
    private String praise;
    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '回复评论'")
    private Long parentId;
}
