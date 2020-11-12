package com.iothings.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iothings.entity.CourseFrame;
import lombok.Data;

import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/03 15:10 PM
 * @Description：
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseFrameVO<T> {
    /** */
    @JsonProperty("list")
    private List<CourseFrame> list;
}
