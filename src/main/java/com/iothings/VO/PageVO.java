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

    @JsonProperty("pase_size")
    private Integer paseSize;

    @JsonProperty("page_no")
    private Integer pageNo;

    @JsonProperty("total")
    private Integer total;

}
