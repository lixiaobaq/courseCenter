package com.iothings.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "course_catalog_note")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseCatalogNoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '课程目录id'")
    private Long courseCatalogId;
    @Column(updatable = false, nullable = true, columnDefinition = "datetime COMMENT '起始时间'")
    private String startTime;
    @Column(updatable = false, nullable = true, columnDefinition = "datetime COMMENT '结束时间'")
    private String endTime;
    private String fromOf;
    private String toOf;
}
