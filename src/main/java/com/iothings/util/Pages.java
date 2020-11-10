package com.iothings.util;

import lombok.Data;

/**
 * @Package： com.iothings.util
 * @author： ZDL
 * @date： 2020/11/10 14:37
 * @version： V1.0
 * @Description：
 */
@Data
public class Pages {

    private int pageNo;//第几页

    private int pageSize;//每页显示几条内容

    private String sortColumn; //排序字段

    private String direction; //排序方式

}
