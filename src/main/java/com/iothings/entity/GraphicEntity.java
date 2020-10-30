package com.iothings.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Huanglei
 * @time:2020/10/28 10:42 AM
 * @Description：
 */
@Table(name="graphic")
@Entity
@Data
public class GraphicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //图像的资源地址
    private String imageUrl;
    //超链接
    private String url;
    //要显示的文字
    private String title;


    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date updateTime;
}
