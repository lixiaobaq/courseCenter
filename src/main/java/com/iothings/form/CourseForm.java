package com.iothings.form;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: Guoyan
 * @time:2020/11/03 10:36 AM
 * @Description：
 */
@Data
@ApiModel(value = "CourseForm", description = "课程Form")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseForm {
    private Integer courseId;
    private String tilte;
    private String subTitle;
    private String introduction;
    private Long frameId;
    private Long createrId;
    //封面
    private String titlePageUrls;
    //0免费 1收费
    private String fee;
    //评分1-5
    private String score;
    //评分人次
    private Long scoreCounts;
    //学习人次
    private Long learnCounts;
    //原价
    private BigDecimal price;
    //现价
    private BigDecimal currentPrice;
    //简介 富文本
    private String summary;

}
