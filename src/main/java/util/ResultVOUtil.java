package util;

import com.iothings.VO.ResultVO;

/**
 * @author: Alex
 * @time:2020/11/03 14:28 PM
 * @Description：
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("success");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO error(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(-1);
        resultVO.setMsg("error");
        resultVO.setData(object);
        return resultVO;
    }

}
