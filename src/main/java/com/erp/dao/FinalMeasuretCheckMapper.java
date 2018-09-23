package com.erp.dao;

import com.erp.bean.FinalMeasuretCheck;

import java.util.HashMap;
import java.util.List;

public interface FinalMeasuretCheckMapper {
    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);

    Integer selectCountUnqualifyApplys();

    List<FinalMeasuretCheck> selectPartFinalMeasuretChecks(HashMap<Object, Object> hashMap);

    Integer selectCountFinalMeasuretChecksByCondition(FinalMeasuretCheck finalMeasuretCheck);

    List<FinalMeasuretCheck> selectFinalMeasuretChecksByCondition(HashMap<Object, Object> hashMap);
}