package com.iothings.VO;

import lombok.Data;

/**
 * 视图层最外层对象
 * @Package： com.iothings.VO
 * @author： ZDL
 * @date： 2020/11/5 10:48
 * @version： V1.0
 * @Description： Web端返回数据封装类
 */
@Data
public class ResultWebVO<T> {

    /** 错误码 */
    private Integer code;
    /** 提示信息 */
    private String msg;
    /** 具体内容 */
    private T result;
}
