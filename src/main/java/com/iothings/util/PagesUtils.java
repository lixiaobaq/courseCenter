package com.iothings.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

/**
 * @Package： com.iothings.util
 * @author： ZDL
 * @date： 2020/11/10 14:39
 * @version： V1.0
 * @Description：
 */
public class PagesUtils {

    //分页大小
    private final static Integer PAGESIZE = 5;
    //默认页数  0开头
    private final static Integer PAGENO = 0;
    //默认排序字段
    private final static String ID = "id";

    public static Pageable createPageRequest(Pages pages) {
        return new PageRequest(pages.getPageNo() <= 0 ? PAGENO : pages.getPageNo(),
                pages.getPageSize() <= 0 ? PAGESIZE : pages.getPageSize(),
                new Sort(null != pages.getDirection() && !"".equals(pages.getDirection()) && pages.getDirection().equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
                        StringUtils.isEmpty(pages.getSortColumn()) ? ID : pages.getSortColumn()));
    }

    /**
     * 封装数据供前台分页格式
     * @param page
     * @return
     */
    public static Object toString(Page page){
        Object obj = new Object();
       // obj.p
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total",page.getTotalElements());
        jsonObject.put("list",page.getContent());
        return jsonObject.toJSONString();
    }

}
