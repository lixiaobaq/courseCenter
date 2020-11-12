package com.iothings.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author: Alex
 * @time:2020/11/9 9:11
 * @Description
 */
@Entity
@Table(name = "course_notes")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, columnDefinition = "int(11) COMMENT '用户id'")
    private String userId;
    @Column(nullable = true, columnDefinition = "varchar(255) COMMENT '内容 '")
    private String content;
    @Column(nullable = true, columnDefinition = "int(11) COMMENT '课程id'")
    private Integer courseId;
    @Column(nullable = true, columnDefinition = "Date COMMENT '提交时间'")

    @CreationTimestamp
    private Date updateTime;

    @Column(nullable = true, columnDefinition = "varchar(100) COMMENT '课程视频当前时间'")
    private String linkCourseTime;
    //用户名
    @Transient
    private String userName;
    //用户头像
    @Transient
    private String userImg;
}
