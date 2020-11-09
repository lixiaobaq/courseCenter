package com.iothings.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;

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

    @Column(nullable = true, columnDefinition = "bigint COMMENT '行业id、所属资历'")
    private Long courseFrameId;

    @Column(nullable = true, columnDefinition = "varchar(300) COMMENT '资历课程课程id'")
    private String courseId;

    @Column(nullable = true, columnDefinition = "varchar(50) COMMENT '课程'")
    private String course;

    @Column(nullable = true, columnDefinition = "decimal(11,2) COMMENT '认证费用'")
    private BigDecimal price ;

    @Column(nullable = true, columnDefinition = "int COMMENT '认证封面关联id'")
    private Integer groupImgId ;

    @Column(nullable = true, columnDefinition = "varchar(50) COMMENT '证书标题'")
    private String title;

    @Column(nullable = true, columnDefinition = "varchar(50) COMMENT '证书认证机构'")
    private String authentication;

    @Column(nullable = true, columnDefinition = "int COMMENT '证书认证机构id'")
    private int authenticationId;

    @Column(nullable = true, columnDefinition = "varchar(50) COMMENT '学分'")
    private int credit;

    @Column(nullable = true, columnDefinition = "text COMMENT '认证介绍'")
    private String content;

}
