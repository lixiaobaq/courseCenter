package com.iothings.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Package： com.iothings.entity
 * @author： ZDL
 * @date： 2020/11/6 10:53
 * @version： V1.0
 * @Description：
 */
@Entity
@Table(name = "groupImg")
@Data
public class GroupImgEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, columnDefinition = "bigint COMMENT '项目ID'")
    private Long proId;

    @Column(nullable = true, columnDefinition = "varchar(100) COMMENT '图片路径'")
    private String imgUrl;

    @Column(nullable = true, columnDefinition = "char(1) COMMENT '是否封面 1是 2不是'")
    private String isCover;

    @Column(nullable = true, columnDefinition = "varchar(10) COMMENT '所属分类'")
    private String type;
}
