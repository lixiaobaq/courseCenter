package com.iothings.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iothings.entity.CertificationCenterEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

/**
 * @Package： com.iothings.VO
 * @author： ZDL
 * @date： 2020/11/5 10:01
 * @version： V1.0
 * @Description：
 */
public class UserCertificationVO {

    private Long id;

    private String certificateImage;

    private String certificateName;

    private boolean assessmentStatus ;

    private Date assessmentTime ;
    private boolean isApply;


}
