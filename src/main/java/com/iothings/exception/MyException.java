package com.iothings.exception;

import com.iothings.enums.ResultEnum;

/**
 * @author: Huanglei
 * @time:2020/10/30 10:45 AM
 * @Description：
 */
public class MyException extends RuntimeException {

    private Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
