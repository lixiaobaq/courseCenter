package com.iothings.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

/**
 * @author: Guoyan
 * @time:2020/11/03 10:36 AM
 * @Description：
 */
@Data
@ApiModel(value = "PopularCertificatesForm", description = "认证Form")
public class PopularCertificatesForm {
    private Long courseFrameId;

    private String courseId;

    private BigDecimal price ;

    private Integer groupImgId ;

    private String title;

    private int authenticationId;

    private int credit;

    private String content;
}
