package com.iothings.util;

import com.iothings.entity.Pages;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StringUtils;

/**
 * @author: Alex
 * @time:2020/11/10 9:35
 * @Description
 */

public class PagesUtils {
        //分页大小
    private final static Integer SIZE = 5;
        //默认页数  0开头
    private final static Integer PAGE = 0;
        //默认排序字段
    private final static String ID = "id";
    public static Pageable createPageRequest(Pages pages) {
        return new PageRequest(pages.getPage()<=0?PAGE:pages.getPage(),
                pages.getSize()<=0?SIZE:pages.getSize(),
        new Sort(null!=pages.getDirection()&&!"".equals(pages.getDirection())&&pages.getDirection().equals("desc")?Direction.DESC:Direction.ASC,
                StringUtils.isEmpty(pages.getSortColumn())?ID:pages.getSortColumn()));
    }
}
