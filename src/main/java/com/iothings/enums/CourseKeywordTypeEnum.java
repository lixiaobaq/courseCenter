package com.iothings.enums;

import lombok.Getter;

@Getter
public enum CourseKeywordTypeEnum {

    NAME("1", "名称"),
    ID("2", "id"),
    USER("3", "用戶"),
    ORGAN("4", "机构"),
    UNKNOWN("5", "未知");

    CourseKeywordTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    public static CourseKeywordTypeEnum getByType(String type){
        for (CourseKeywordTypeEnum constants : values()) {
            if (constants.getMessage().equalsIgnoreCase(type)) {
                return constants;
            }
        }
        return UNKNOWN;
    }
}
