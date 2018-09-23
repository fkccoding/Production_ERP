package com.erp.service.a;

import com.erp.bean.Work;

import java.util.List;

public interface WorkService {
    int getTotalCount();

    List<Work> selectListByPageAndRows(Integer page, Integer rows);

    boolean insert(Work work);

    boolean delete(String id);

    boolean update(Work work);

    List<Work> selectAll();

    Work findById(String id);

    int getCountById(String searchValue);

    List<Work> selectListById(Integer page, Integer rows, String searchValue);

    int getCountByProductId(String productId);

    List<Work> selectListByProductId(Integer page, Integer rows, String productId);

    int getCountByProcessId(String searchValue);

    List<Work> selectListByProcessId(Integer page, Integer rows, String searchValue);

    int getCountByDeviceId(String deviceId);

    List<Work> selectListByDeviceId(Integer page, Integer rows, String deviceId);
}
