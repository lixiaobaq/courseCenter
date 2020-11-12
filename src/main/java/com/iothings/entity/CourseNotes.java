package com.iothings.entity;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Alex
 * @time:2020/11/9 9:11
 * @Description
 */
@Entity
@Table(name = "course_notes")
@Data
public class CourseNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, columnDefinition = "int(11) COMMENT '用户id'")
    private Integer userId;
    @Column(nullable = true, columnDefinition = "varchar(255) COMMENT '图片路径'")
    private String image;
    @Column(nullable = true, columnDefinition = "varchar(255) COMMENT '内容 '")
    private String content;
    @Column(nullable = true, columnDefinition = "int(11) COMMENT '课程id'")
    private Integer courseId;
    @Column(nullable = true, columnDefinition = "Date(0) COMMENT '提交时间'")
    @UpdateTimestamp
    private Date updateTime;
    @Column(nullable = true, columnDefinition = "varchar(100) COMMENT '课程视频当前时间'")
    private String courseTime;
}
