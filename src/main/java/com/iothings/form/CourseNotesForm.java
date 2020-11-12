package com.iothings.form;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author: Alex
 * @time:2020/11/9 10:11
 * @Description
 */
@Data
@ApiModel(value = "CourseNotesForm", description = "课程笔记Form")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseNotesForm {
    private Long id;
    private String userId;
    private String content;
    private Integer courseId;
    private String linkCourseTime;
}
