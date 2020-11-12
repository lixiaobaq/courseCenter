package com.iothings.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "course_learning_progress")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseLearningProgressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long courseCatalogId;
    private Long userId;
    //学习进度
    private String progress  ;
}
