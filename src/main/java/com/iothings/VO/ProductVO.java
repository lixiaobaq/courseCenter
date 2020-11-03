package com.iothings.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: Huanglei
 * @time:2020/10/27 9:32 PM
 * @Description：
 */
@Data
public class ProductVO<T> {
    /** */
    @JsonProperty("name1")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("list")
    private List<T> dataList;
}
