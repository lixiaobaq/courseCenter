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
    private String name;
    private String sort;
    private Integer level;
    private Integer parentid;
    private Integer status;
    @Transient
    private List<Business> children;
    @Transient
    private Integer num;
}
