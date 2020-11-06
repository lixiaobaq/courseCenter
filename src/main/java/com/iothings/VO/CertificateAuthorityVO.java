package com.iothings.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iothings.entity.CertificateAuthorityEntity;

import java.util.List;

/**
 * @Package： com.iothings.VO
 * @author： ZDL
 * @date： 2020/11/5 10:01
 * @version： V1.0
 * @Description：
 */
public class CertificateAuthorityVO {

    @JsonProperty("list")
    private List<CertificateAuthorityEntity> list;
}
