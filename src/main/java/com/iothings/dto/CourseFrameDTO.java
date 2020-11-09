package com.iothings.dto;


import lombok.Data;
import lombok.Value;

import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/6 15:18
 * @Description
 */
@Data
@Value
public class CourseFrameDTO {

    private Long id;
    private String name;
    private String sort;
    private Integer parentid;
    private Integer status;
    private List<CourseFrameDTO> children;
    private Integer coursenum;

    public CourseFrameDTO(Long id, String name, String sort, Integer parentid, Integer status, List<CourseFrameDTO> children, Integer coursenum){
        this.id = id;
        this.name = name;
        this.sort = sort;
        this.parentid = parentid;
        this.status = status;
        this.children = children;
        this.coursenum = coursenum;
    }
}
