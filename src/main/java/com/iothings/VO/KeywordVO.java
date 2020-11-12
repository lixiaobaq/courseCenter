package com.iothings.VO;

import lombok.Data;

@Data
public class KeywordVO {

    private String keywords;

    private String keywordType;

    private String industry;

    private String verifyStatus;

    private String styleId;

    //行业方向（不传默认全部）
    private String direction;
    //课程分类（不传默认全部）
    private String courseSort;
    //课程类型（不传默认全部）
    private String courseType;
    //0最热, 1最新(默认0)
    private String type;
}
