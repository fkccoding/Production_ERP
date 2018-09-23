package com.erp.dao;

import com.erp.bean.Product;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    int selectTotalCount();

    List<Product> selectListByPageAndRows(Map<String, Object> map);

    List<Product> selectAll();

    List<Product> selectByName(String name);

    String findIdByName(String searchValue);

    int getCountById(String searchValue);

    List<Product> selectListById(Map<String, Object> map);

    int getCountByName(String searchValue);

    List<Product> selectListByName(Map<String, Object> map);

    int getCountByType(String searchValue);

    List<Product> selectListByType(Map<String, Object> map);
}