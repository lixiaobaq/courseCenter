package com.iothings.exception;

import com.iothings.VO.ResultWebVO;
import com.iothings.enums.ResultEnum;

/**
 * @Package： com.iothings.exception
 * @author： ZDL
 * @date： 2020/11/9 14:47
 * @version： V1.0
 * @Description： 上传文件类型不匹配时异常
 */
public class UnsupportedFileTypeException extends Exception{

    private Integer code;


    public UnsupportedFileTypeException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public UnsupportedFileTypeException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
