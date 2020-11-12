package com.iothings.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iothings.entity.Business;
import com.iothings.entity.Seniority;
import lombok.Data;

import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/7 16:21
 * @Description
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeniorityVO {
    @JsonProperty("list")
    private List<Seniority> list;
}
