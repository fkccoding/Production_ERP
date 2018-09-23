package com.erp.dao;

import com.erp.bean.Work;

import java.util.List;
import java.util.Map;

public interface WorkMapper {
    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(String workId);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    int selectTotalCount();

    List<Work> selectListByPageAndRows(Map<String, Object> map);

    List<Work> selectAll();

    int getCountById(String searchValue);

    List<Work> selectListById(Map<String, Object> map);

    int getCountByProductId(String productId);

    List<Work> selectListByProductId(Map<String, Object> map);

    int getCountByProcessId(String searchValue);

    List<Work> selectListByProcessId(Map<String, Object> map);

    int getCountByDeviceId(String deviceId);

    List<Work> selectListByDeviceId(Map<String, Object> map);
}