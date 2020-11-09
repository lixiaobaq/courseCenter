package com.iothings.controller;

import com.iothings.VO.ResultVO;
import com.iothings.enums.ResultEnum;
import com.iothings.util.FileUtils;
import com.iothings.util.ResultVOUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Package： com.iothings.controller
 * @author： ZDL
 * @date： 2020/11/9 11:23
 * @version： V1.0
 * @Description：文件上传
 */
@RestController
@RequestMapping("/api/")
public class FileUploadController {

    @PostMapping("/common/upload")
    public ResultVO upload(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "file", required = false) MultipartFile file) {
        ResultVO resultVO = new ResultVO();
        try {
            if (null != file && file.getSize() > 0) {
                String filePath = FileUtils.saveFile(file);
                resultVO.setMsg("WLHhSO");
                resultVO = ResultVOUtil.success(filePath);
            }
        } catch (Exception e) {
            resultVO = ResultVOUtil.error(ResultEnum.PARAM_ERROR.getMessage());
            e.printStackTrace();
        }
        return resultVO;
    }
}
