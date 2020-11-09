package com.iothings.util;

import com.iothings.VO.ResultWebVO;

public class ResultWebVOUtil {

    public static ResultWebVO success(Object object) {
        ResultWebVO resultVO = new ResultWebVO();
        resultVO.setCode(0);
        resultVO.setResult("success");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultWebVO save_error(Object object) {
        ResultWebVO resultVO = new ResultWebVO();
        resultVO.setCode(10000);
        resultVO.setResult("error");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultWebVO user_null(Object object) {
        ResultWebVO resultVO = new ResultWebVO();
        resultVO.setCode(10001);
        resultVO.setResult("error");
        resultVO.setData(object);
        return resultVO;
    }
}
