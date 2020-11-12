package com.iothings.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author: Alex
 * @time:2020/11/11 10:45
 * @Description
 */
@Data
@ApiModel(value = "BusinessForm", description = "行业分类Form")
public class BusinessForm {
    private Long id;
    private String name;
    private String sort;
    private Integer level;
    private Integer parentId;
    private Integer releas_status;
    private String isOpen;
}
