package com.iothings.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iothings.entity.Business;
import lombok.Data;

import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/6 14:22
 * @Description
 */
@Data
public class BusinessVO {
    @JsonProperty("list")
    private List<Business> list;
}
