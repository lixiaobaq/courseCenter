package com.iothings.VO;

import lombok.Data;

/**
 * 视图层最外层对象
 * @author: Guoyan
 */
@Data
public class ResultWebVO<T> {

    /** 错误码 */
    private Integer code;
    /** 提示信息 */
    private String result;
    /** 具体内容 */
    private T data;
}
