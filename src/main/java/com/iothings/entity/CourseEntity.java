package com.iothings.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: Huanglei
 * @time:2020/10/28 10:16 AM
 * @Description：
 */
@Entity
@Table(name = "course")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, columnDefinition = "varchar(50) COMMENT '标题'")
    private String title;

    @Column(nullable = true, columnDefinition = "varchar(150) COMMENT '副标题'")
    private String subTitle;

    @Column(nullable = true, columnDefinition = "longtext COMMENT '介绍'")
    private String introduction;

    @Column(nullable = true, columnDefinition = "varchar(255) COMMENT '分类id'")
    private String frameId;

    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '创建者id'")
    private Long createrId;

    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '产业id'")
    private Long industry;

    @Column(nullable = true, columnDefinition = "varchar(255) COMMENT '封面'")
    private String titlePageUrls;

    @Column(nullable = true, columnDefinition = "char(1) COMMENT '0免费 1收费'")
    private String fee;

    @Column(nullable = true, columnDefinition = "char(1) COMMENT '评分1-5'")
    private String score;

    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '评分人次'")
    private Long scoreCounts;

    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '学习人次'")
    private Long learnCounts;

    @Column(nullable = true, columnDefinition = "decimal(20) COMMENT '原价'")
    private BigDecimal price;

    @Column(nullable = true, columnDefinition = "decimal(20) COMMENT '现价'")
    private BigDecimal currentPrice;

    @Column(nullable = true, columnDefinition = "longtext COMMENT '简介 富文本'")
    private String summary;

    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '创建机构id'")
    private Long organ;

    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date updateTime;
}
