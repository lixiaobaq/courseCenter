package com.iothings.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "course_commnet")
@Data
@MappedSuperclass
public class CourseCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, columnDefinition = "bigint COMMENT '课程id'")
    private Long courseId;
    @Column(nullable = true, columnDefinition = "bigint COMMENT '评分'")
    private Long score;
    @Column(nullable = true, columnDefinition = "varchar COMMENT '评价'")
    private String evaluate;
    @Column(nullable = true, columnDefinition = "bigint COMMENT '评分人次'")
    private Long scoreCounts;
    @Column(nullable = true, columnDefinition = "bigint COMMENT '学习人次'")
    private Long learnCounts;
}
