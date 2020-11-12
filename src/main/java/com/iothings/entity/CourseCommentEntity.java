package com.iothings.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "course_commnet")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '课程id'")
    private Long courseId;
    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '评分'")
    private Long score;
    @Column(nullable = true, columnDefinition = "longtext COMMENT '评价'")
    private String evaluate;
    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '评分人次'")
    private Long scoreCounts;
    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '学习人次'")
    private Long learnCounts;
}
