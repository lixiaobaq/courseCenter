package com.iothings.enums;

import lombok.Getter;

/**
 * @author: Alex
 * @time:2020/11/03 14:28 AM
 * @Description：
 */
@Getter
public enum ResultEnum {

    PARAM_ERROR(1, "参数不正确"),
    TOKEN_NULL(2, "token为空"),
    TOKEN_INVALID(3, "token无效"),
    CARSTLE_NULL(4, "所选车型不存在"),
    PASSWORD_ERROR(5, "密码错误"),
    MANAGER_ERROR(6, "后台错误"),;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;

}