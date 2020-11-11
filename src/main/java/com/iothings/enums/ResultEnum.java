package com.iothings.enums;

import lombok.Getter;

/**
 * @author: Alex
 * @time:2020/11/03 14:28 AM
 * @Description：
 */
@Getter
public enum ResultEnum {
    EDFAULT_PARAMETERS_ONE_SUCCES(1,"默认参数1"),
    EDFAULT_PARAMETERS_ZERO_SUCCES(0,"默认参数0"),
    ADD_SUCCES(1,"添加成功"),
    ADD_ERROR(-1,"添加失败"),
    EDIT_SUCCES(1,"修改成功"),
    EDIT_ERROR(-1,"修改失败"),
    DELETE_SUCCES(1,"删除成功"),
    DELETE_ERROR(-1,"删除失败"),
    STATUS_TYPE_UP(1,"上架状态"),
    STATUS_TYPE_DOWN(0,"下架状态"),
    PARAM_ERROR(1, "参数不正确"),
    TOKEN_NULL(2, "token为空"),
    TOKEN_INVALID(3, "token无效"),
    CARSTLE_NULL(4, "所选车型不存在"),
    PASSWORD_ERROR(5, "密码错误"),
    MANAGER_ERROR(6, "后台错误"),
    EXISTS_ERROR(-1, "数据不存在"),;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;

}