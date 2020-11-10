package com.iothings.enums;

import lombok.Getter;

@Getter
public enum CoursePublishEnum {

    NEW("0", "新提交"),
    PASS("1", "通过"),
    NO_PASS("2", "不通过"),
    PUBLISH("3", "发布");

    CoursePublishEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    public static CoursePublishEnum getByType(String type){
        for (CoursePublishEnum constants : values()) {
            if (constants.getCode().equalsIgnoreCase(type)) {
                return constants;
            }
        }
        return null;
    }
}
