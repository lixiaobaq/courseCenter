package com.iothings.VO;

import lombok.Data;

/**
 * 视图层最外层对象
 * @author: Huanglei
 * @time:2020/10/27 9:28 PM
 * @Description：
 */
@Data
public class ResultVO<T> {

    /** 错误码 */
    private Integer code;
    /** 提示信息 */
    private String msg;
    /** 具体内容 */
    private T data;
}
