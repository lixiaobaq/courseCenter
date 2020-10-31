package com.iothings.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "course_catalog_note")
@Data
public class CourseCatalogNoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long courseCatalogId;
    private String startTime;
    private String endTime;
    private String from;
    private String to;
}
