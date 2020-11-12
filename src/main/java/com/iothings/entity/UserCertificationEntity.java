package com.iothings.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * @Package： com.iothings.entity
 * @author： ZDL
 * @date： 2020/11/09 11:07
 * @version： V1.0
 * @Description：
 */
//@AllArgsConstructor
@Entity
@Table(name = "userCertificates")
@Data
public class UserCertificationEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, columnDefinition = "varchar(100) COMMENT '证书图片'")
    private String certificateImage;

    @Column(nullable = true, columnDefinition = "varchar(100) COMMENT '证书名称'")
    private String certificateName;

    @Column(nullable = true, columnDefinition = "tinyint(1) COMMENT '考核状态'")
    private boolean assessmentStatus ;

    //@Transient
    @Column(nullable = true, columnDefinition = "datetime COMMENT '考核时间'")
    @CreationTimestamp
    private Date assessmentTime ;

    @Column(length=1,nullable = true, columnDefinition = "tinyint(1) COMMENT '是否申请纸质证书 1:是 0:不是'")
    private boolean isApply;

   /* @OneToMany(mappedBy = "userCertificationEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<CertificationCenterEntity> certificationCenterEntity;*/
}
