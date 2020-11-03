package com.iothings.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author: Alex
 * @time:2020/10/29 10:29 PM
 * @Description：课程分类
 */
@Entity
@Table(name = "course_frame")
@Data
public class CourseFrame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sort;
    private Integer level;
    private Integer parentid;
    private Integer status;
//    @OneToMany(targetEntity = CourseFrame.class)
    @Transient
    private List<CourseFrame> children;
    @Transient
    private Integer coursenum;

    public CourseFrame(){

    }

    public void chanegParent(){}

    public void changeStatus(){}
}
