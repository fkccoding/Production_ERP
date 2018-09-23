package com.erp.dao;

import com.erp.bean.ProcessMeasureCheck;

import java.util.HashMap;
import java.util.List;

public interface ProcessMeasureCheckMapper {
    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasureCheck record);

    int insertSelective(ProcessMeasureCheck record);

    ProcessMeasureCheck selectByPrimaryKey(String pMeasureCheckId);

    int updateByPrimaryKeySelective(ProcessMeasureCheck record);

    int updateByPrimaryKey(ProcessMeasureCheck record);

    Integer selectCountprocessMeasureChecks();

    List<ProcessMeasureCheck> selectPartProcessMeasureChecks(HashMap<Object, Object> hashMap);

    List<ProcessMeasureCheck> search_pMeasureCheck_by_pMeasureCheckId(HashMap<Object, Object> hashMap);
}