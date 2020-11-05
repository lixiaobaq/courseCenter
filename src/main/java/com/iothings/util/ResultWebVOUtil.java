package com.iothings.util;

import com.iothings.VO.ResultWebVO;

/**
 * 视图层最外层对象
 * @Package： com.iothings.util
 * @author： ZDL
 * @date： 2020/11/5 10:48
 * @version： V1.0
 * @Description： Web端返回数据封装类
 */
public class ResultWebVOUtil {

    public static ResultWebVO success(Object object) {
        ResultWebVO resultWebVO = new ResultWebVO();
        resultWebVO.setCode(0);
        resultWebVO.setMsg("success");
        resultWebVO.setResult(object);
        return resultWebVO;
    }

    public static ResultWebVO error(Object object) {
        ResultWebVO resultWebVO = new ResultWebVO();
        resultWebVO.setCode(10000);
        resultWebVO.setMsg("error");
        resultWebVO.setResult(object);
        return resultWebVO;
    }
}
