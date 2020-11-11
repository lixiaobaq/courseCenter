package com.iothings.controller;

import com.iothings.VO.PageBeanVO;
import com.iothings.VO.PageVO;
import com.iothings.VO.ResultWebVO;
import com.iothings.entity.UserCertificationEntity;
import com.iothings.service.UserCertificationService;
import com.iothings.util.Pages;
import com.iothings.util.PagesUtils;
import com.iothings.util.ResultWebVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Package： com.iothings.controller
 * @author： ZDL
 * @date： 2020/11/5 10:48
 * @version： V1.0
 * @Description：
 */
@RestController
@RequestMapping("/api/")
public class UserCertificationController {

    @Autowired
    private UserCertificationService userCertificationService;

    /**
     * 分页查询所有用户（动态页数，每页大小，排序方式，排序字段）
     * 包括动态条件查询（属性值）
     * 规则：无输入条件，默认查询全部。默认返回第一页 每页5条，默认asc排序，默认id排序。
     */
   // @RequestMapping(value="/myCertificate",method={RequestMethod.POST, RequestMethod.GET})
    @PostMapping("myCertificate")
    public ResultWebVO<Page<UserCertificationEntity>> findAll(Pages pages, UserCertificationEntity userCertificationEntity){
        ResultWebVO resultWebVO = new ResultWebVO();
        PageBeanVO pageBeanVO = new PageBeanVO();
        Page page = userCertificationService.findAll(userCertificationEntity, PagesUtils.createPageRequest(pages));
        pageBeanVO.setTotal((int)page.getTotalElements());
        pageBeanVO.setDataList(page.getContent());
        resultWebVO = ResultWebVOUtil.success(pageBeanVO);
        return resultWebVO;
    }

}
