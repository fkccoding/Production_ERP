package com.erp.utils;

import java.util.HashMap;

/**
 * @Author:YueZhenLi
 * @Date:Created in 2018/8/31
 */
public class PageModelHelper {

        public static void ModelHelper(Integer page, Integer rows, Integer count, HashMap<Object, Object> hashMap) {
        PageModel pageModel = new PageModel();
        //设置分页需要的参数（符合条件的数据总数、当前页码、每页显示的行数）
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(page);
        pageModel.setPageSize(rows);

        //获取数据库查询的分页条件（limit、offset）
        Integer limit = pageModel.getPageSize();
        Integer offset = pageModel.getFirstLimitParam();

        hashMap.put("limit", limit);
        hashMap.put("offset", offset);
    }
}
