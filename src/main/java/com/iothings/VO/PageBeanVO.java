package com.iothings.VO;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Guoyan
 */
@Data
public class PageBeanVO {

    @JSONField(ordinal=1)
    @JsonProperty("list")
    private Object dataList;

    @JSONField(ordinal=2)
    @JsonProperty("total")
    private Integer total;

}
