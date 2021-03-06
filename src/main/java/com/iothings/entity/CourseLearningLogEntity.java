package com.iothings.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "course_learning_log")
@Data
public class CourseLearningLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, columnDefinition = "longtext COMMENT '内容'")
    private String content;
    @Column(nullable = true, columnDefinition = "varchar COMMENT '资源类型'")
    private String resourceType;
    @Column(nullable = true, columnDefinition = "varchar COMMENT '是视频时，对应当前资源的播放位置时间'")
    private String playtime;
    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '是文档时，记录当前页数'")
    private Long pages;
}
