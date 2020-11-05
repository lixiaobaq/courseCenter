package com.iothings.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Guoyan
 */
@Data
public class PageVO {

    @JsonProperty("list")
    private Object dataList;

    @JsonProperty("paseSize")
    private Integer paseSize;

    @JsonProperty("pageNo")
    private Integer pageNo;

    @JsonProperty("total")
    private Integer total;

}
