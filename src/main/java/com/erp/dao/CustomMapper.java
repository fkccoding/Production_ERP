package com.erp.dao;

import com.erp.bean.COrder;
import com.erp.bean.Custom;

import java.util.List;
import java.util.Map;

public interface CustomMapper {
    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    int insertSelective(Custom record);

    Custom selectByPrimaryKey(String customId);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    int selectTotalCount();

    List<Custom> selectListByPageAndRows(Map<String, Object> map);

    List<Custom> selectAll();

    int getCountByName(String searchValue);

    List<Custom> selectListByName(Map<String, Object> map);

    String findIdByName(String searchValue);

    int getCountById(String searchValue);

    List<Custom> selectListById(Map<String, Object> map);
}