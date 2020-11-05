package com.iothings.entity;

import lombok.Data;
import javax.persistence.*;

/**
 * @Package： com.iothings.entity
 * @author： ZDL
 * @date： 2020/11/4 16:07
 * @version： V1.0
 * @Description：
 */
@Entity
@Table(name = "popularCertificates")
@Data
public class CertificationCenterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, columnDefinition = "varchar(50) COMMENT '证书图片'")
    private String img ;
    @Column(nullable = true, columnDefinition = "varchar(50) COMMENT '证书标题'")
    private String title;
    @Column(nullable = true, columnDefinition = "varchar(50) COMMENT '证书认证机构'")
    private String authentication;
    @Column(nullable = true, columnDefinition = "varchar(50) COMMENT '学分'")
    private int credit;
    @Column(nullable = true, columnDefinition = "varchar(50) COMMENT '课程'")
    private String course;

}
