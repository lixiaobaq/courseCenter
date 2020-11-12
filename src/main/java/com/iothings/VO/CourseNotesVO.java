package com.iothings.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iothings.entity.CourseNotes;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/9 10:11
 * @Description
 */
@Data
public class CourseNotesVO {
    private Long id;
    private String userId;
    private String content;
    private Integer courseId;
    private Date updateTime;
    private String linkCourseTime;
    private String userName;
    private String userImg;
    @JsonProperty("list")
    private List<CourseNotes> list;
}
