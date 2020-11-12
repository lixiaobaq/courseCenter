package com.iothings.entity;

import lombok.AllArgsConstructor;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Alex
 * @time:2020/11/10 9:31
 * @Description
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pages {
    private int page;//第几页
    private int size;//每页显示几条内容
    private String sortColumn; //排序字段
    private String direction; //排序方式
    @Override
    public String toString() {
        return JSON.toJSONString(this, true);
    }
}
