package com.erp.service.e.impl;

import com.erp.bean.ProcessMeasureCheck;
import com.erp.dao.ProcessMeasureCheckMapper;
import com.erp.service.e.ProcessMeasureCheckService;
import com.erp.utils.PageModelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author:YueZhenLi
 * @Date:Created in 2018/8/31
 */
@Service
public class ProcessMeasureCheckServiceImpl implements ProcessMeasureCheckService{

    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;

    @Override
    public List<ProcessMeasureCheck> selectPartProcessMeasureChecks(Integer page, Integer rows) {
        HashMap<Object, Object> hashMap = new HashMap<>();

        //设置分页显示的数据，并把limit,offset 存入map中
        Integer count = processMeasureCheckMapper.selectCountprocessMeasureChecks();
        PageModelHelper.ModelHelper(page, rows, count, hashMap);

        List<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckMapper.selectPartProcessMeasureChecks(hashMap);

        return processMeasureChecks;
    }

    @Override
    public List<ProcessMeasureCheck> search_pMeasureCheck_by_pMeasureCheckId(String searchValue, Integer page, Integer rows) {

        HashMap<Object, Object> hashMap = new HashMap<>();

        Integer count = processMeasureCheckMapper.selectCountprocessMeasureChecks();
        PageModelHelper.ModelHelper(page, rows, count, hashMap);

        String likeSearchValue = "%"+ searchValue + "%";
        hashMap.put("searchValue", likeSearchValue);

        List<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckMapper.search_pMeasureCheck_by_pMeasureCheckId(hashMap);

        return processMeasureChecks;
    }


}
