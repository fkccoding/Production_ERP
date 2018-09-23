package com.erp.dao;

import com.erp.bean.Manufacture;

import java.util.List;
import java.util.Map;

public interface ManufactureMapper {
    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);

    int selectTotalCount();

    List<Manufacture> selectListByPageAndRows(Map<String, Object> map);

}