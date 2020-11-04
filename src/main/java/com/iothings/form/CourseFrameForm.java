package com.iothings.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: Guoyan
 * @time:2020/11/03 10:36 AM
 * @Description：
 */
@Data
@ApiModel(value = "CourseFrameForm", description = "课程分类Form")
public class CourseFrameForm {
    private String courseframeName;
    private String courseFrameSort;
    private Integer courseFrameLevel;
    private Integer courseFrameParentid;

}
