package com.iothings.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "course_catalog_discuss")
@Data
public class CourseCatalogDiscussEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long courseCatalogId;
    private Long userId;
    private String username;
    //评论时间
    @Column(updatable = false)
    @CreationTimestamp
    private Date time;
    //赞
    private String praise;
    //回复评论
    private Long parentId;
}
