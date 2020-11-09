package com.iothings.dto;

import lombok.Data;
import lombok.Value;

import javax.persistence.*;
import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/6 11:04
 * @Description
 */
@Value
@Data
public class BusinessDTO {
    private Long id;
    private String name;
    private String sort;
    private Integer level;
    private Integer parentid;
    private Integer status;
}
