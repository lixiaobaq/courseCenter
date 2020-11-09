package com.iothings.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Guoyan
 */
@Entity
@Table(name = "course_publish")
@Data
public class CoursePublishEntity extends CourseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long courseId;
    //版本号
    private String versionNumber;
    //提交者
    private Long submitterId;
    //审核者
    private Long inspectorId;
    //发布者
    private Long promulgatorId;
    //0新提交 1通过 2不通过 3发布
    private String status;
    @Column(updatable = false)
    @CreationTimestamp
    private Date inspectTime;
    @Column(updatable = false)
    @CreationTimestamp
    private Date publishTime;
    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date updateTime;
    //0最热, 1最新(默认0)
    private String type;
}
