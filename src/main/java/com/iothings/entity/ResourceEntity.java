package com.iothings.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "resource")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long courseId;
    @Column(nullable = true, columnDefinition = "varchar(50) COMMENT '标题'")
    private String name;

    @Column(nullable = true, columnDefinition = "varchar(10) COMMENT '后缀'")
    private String suffix;

    @Column(nullable = true, columnDefinition = "char(1) COMMENT '0视频 1图片 2音频 3ppt 4word 5 pdf'")
    private String resourceType;

    @Column(nullable = true, columnDefinition = "varchar(255) COMMENT '资源路径'")
    private String resourseUrl;

    @Column(nullable = true, columnDefinition = "char(1) COMMENT '允许试看 0允许 1不允许'")
    private String allowExperience;

    @Column(nullable = true, columnDefinition = "varchar(20) COMMENT '试看时长'")
    private String experienceTime;

}
