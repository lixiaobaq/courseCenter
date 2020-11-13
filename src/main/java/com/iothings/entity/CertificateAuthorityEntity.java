package com.iothings.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

/**
 * @Package： com.iothings.entity
 * @author： ZDL
 * @date： 2020/11/4 16:07
 * @version： V1.0
 * @Description：
 */
@Entity
@Table(name = "authority")
//@Data
@Getter
@Setter

@EntityListeners(AuditingEntityListener.class)
public class CertificateAuthorityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, columnDefinition = "varchar(100) COMMENT '标题'")
    private String title;
    @Column(nullable = true, columnDefinition = "varchar(100) COMMENT '地点'")
    private String position;

    @OneToMany(mappedBy="certificateAuthorityEntity",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<CertificationCenterEntity> certifications ;

}
