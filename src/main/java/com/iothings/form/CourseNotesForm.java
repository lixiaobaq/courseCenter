package com.iothings.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author: Alex
 * @time:2020/11/9 10:11
 * @Description
 */
@Data
@ApiModel(value = "CourseNotesForm", description = "课程笔记Form")
public class CourseNotesForm {
    private String id;
}
