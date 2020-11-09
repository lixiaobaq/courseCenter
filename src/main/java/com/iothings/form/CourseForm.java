package com.iothings.form;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CourseForm {
    @JsonProperty("course_id")
    private String courseId;
    @JsonProperty("tilte")
    private String tilte;
    @JsonProperty("sub_title")
    private String subTitle;
    @JsonProperty("introduction")
    private String introduction;
    @JsonProperty("frame_id")
    private String frameId;
    @JsonProperty("creater_id")
    private String createrId;
    @JsonProperty("style_id")
    private String styleId;
    @JsonProperty("images")
    private String images;
    @JsonProperty("content")
    private String content;
    @JsonProperty("industry")
    private String industry;
    @JsonProperty("verify_status")
    private String verifyStatus;
    @JsonProperty("reason")
    private String reason;
    //封面
    @JsonProperty("title_page_urls")
    private String titlePageUrls;
    //0免费 1收费
    @JsonProperty("fee")
    private String fee;
    //评分1-5
    @JsonProperty("score")
    private String score;
    //评分人次
    @JsonProperty("score_counts")
    private String scoreCounts;
    //学习人次
    @JsonProperty("learn_counts")
    private String learnCounts;
    //原价
    @JsonProperty("price")
    private String price;
    //现价
    @JsonProperty("current_price")
    private String currentPrice;
    //简介 富文本
    @JsonProperty("summary")
    //评价
    private String summary;
    @JsonProperty("evaluate")
    private String evaluate;
    @JsonProperty("pageSize")
    private Integer pageSize;
    @JsonProperty("pageOn")
    private Integer pageOn;
    @JsonProperty("direction")
    private String direction;
    @JsonProperty("courseSort")
    private String courseSort;
    @JsonProperty("courseType")
    private String courseType;
    @JsonProperty("type")
    private String type;
}
