package com.iothings.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/7 14:40
 * @Description
 */
@Entity
@Table(name = "seniority")
@Data
public class Seniority {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sort;
    private Integer level;
    private Integer parentid;
    private Integer status;
    @Transient
    private List<Seniority> children;
    @Transient
    private Integer num;
}
