package com.iothings.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iothings.entity.CourseNotes;
import lombok.Data;

import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/9 10:11
 * @Description
 */
@Data
public class CourseNotesVO {
    @JsonProperty("list")
    private List<CourseNotes> list;
}
