package com.iothings.entity;

import com.iothings.dto.CourseFrameDTO;
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
    @Column(nullable = true, columnDefinition = "varchar(100) COMMENT '标题'")
    private String name;
    @Column(nullable = true, columnDefinition = "varchar(100) COMMENT '排序'")
    private String sort;
    @Column(nullable = true, columnDefinition = "varchar(100) COMMENT '等级'")
    private Integer level;
    @Column(nullable = true, columnDefinition = "int(11) COMMENT '父级id'")
    private Integer parentId;
    private Integer status;
    @Column(nullable = true, columnDefinition = "varchar(100) COMMENT '是否开启'")
    private String isOpen;

    @Transient
    private List<CourseFrame> children;
    @Transient
    private Integer coursenum;

    public CourseFrame(){

    }

    public void chanegParent(){}

    public void changeStatus(){}
}
