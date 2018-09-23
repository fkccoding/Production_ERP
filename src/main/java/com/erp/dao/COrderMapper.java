package com.erp.dao;

import com.erp.bean.COrder;

import java.util.List;
import java.util.Map;

public interface COrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(COrder record);

    int insertSelective(COrder record);

    COrder selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);

    List<COrder> selectListByPageAndRows(Map<String, Object> map);

    int selectTotalCount();

    List<COrder> selectAll();

    List<COrder> selectListById(Map<String, Object> map);

    int getCountById(String searchValue);

    int getCountByCustomId(String customId);

    List<COrder> selectListByCustomId(Map<String, Object> map);

    int getCountByProductId(String productId);

    List<COrder> selectListByProductId(Map<String, Object> map);
}