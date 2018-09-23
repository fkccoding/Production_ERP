package com.erp.service.a;

import com.erp.bean.Custom;

import java.util.List;

public interface CustomService {
    Custom findById(String id);

    boolean update(Custom custom);

    int getTotalCount();

    List<Custom> selectListByPageAndRows(Integer page, Integer rows);

    List<Custom> selectAll();

    boolean insert(Custom custom);

    boolean delete(String id);

    boolean updateAll(Custom custom);

    int getCountByName(String searchValue);

    List<Custom> selectListByName(Integer page, Integer rows, String searchValue);

    String findIdByName(String searchValue);

    int getCountById(String searchValue);

    List<Custom> selectListById(Integer page, Integer rows, String searchValue);
}
