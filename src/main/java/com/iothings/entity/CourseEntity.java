package com.iothings.entity;

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
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subTitle;
    private String introduction;
    private Long frameId;
    private Long createrId;
    private Long industry;
    /**
     * 封面
     */
    private String titlePageUrls;
    /**
     * 0免费 1收费
     */
    private String fee;
    /**
     * 评分1-5
     */
    private String score;
    /**
     * 评分人次
     */
    private Long scoreCounts;
    /**
     * 学习人次
     */
    private Long learnCounts;
    /**
     * 原价
     */
    private BigDecimal price;
    /**
     * 现价
     */
    private BigDecimal currentPrice;
    /**
     * 简介 富文本
     */
    private String summary;
    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date updateTime;
}
