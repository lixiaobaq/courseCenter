package com.iothings.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author: Alex
 * @time:2020/11/11 11:16
 * @Description
 */
@Data
@ApiModel(value = "SeniorityForm", description = "资历分类Form")
public class SeniorityForm {
    private Long id;
    private String name;
    private String sort;
    private Integer level;
    private Integer parentId;
    private Integer releas_status;
    private String isOpen;
}
