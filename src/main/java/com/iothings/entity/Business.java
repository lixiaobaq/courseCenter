package com.iothings.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/6 11:04
 * @Description
 */
@Entity
@Table(name = "business")
@Data
public class Business {
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
    private List<Business> children;
    @Transient
    private Integer num;
}
