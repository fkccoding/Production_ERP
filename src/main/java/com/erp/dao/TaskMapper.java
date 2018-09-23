package com.erp.dao;

import com.erp.bean.Task;

import java.util.List;
import java.util.Map;

public interface TaskMapper {
    int deleteByPrimaryKey(String taskId);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(String taskId);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    int getTotalCount();

    List<Task> selectListByPageAndRows(Map map);

    List<Task> selectAll();

    int getCountById(String searchValue);

    List<Task> selectListById(Map<String, Object> map);

    int getCountByWorkId(String searchValue);

    List<Task> selectListByWorkId(Map<String, Object> map);

    int getCountByManufactureSn(String searchValue);

    List<Task> selectListByManufactureSn(Map<String, Object> map);
}