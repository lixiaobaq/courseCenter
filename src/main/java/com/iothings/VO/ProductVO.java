package com.iothings.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: Huanglei
 * @time:2020/10/27 9:32 PM
 * @Description：
 */
@Data
public class ProductVO {
    /** */
    @JsonProperty("name1")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;

}
