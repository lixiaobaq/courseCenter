package com.iothings.form;


import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author: Alex
 * @time:2020/11/03 10:36 AM
 * @Description：
 */
@Data
@ApiModel(value = "CourseFrameForm", description = "课程分类Form")
public class CourseFrameForm {
    private Long id;
    private String name;
    private String sort;
    private Integer level;
    private Integer parentId;
    private Integer releas_status;
    private String isOpen;
}
