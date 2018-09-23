package com.erp.dao;

import com.erp.bean.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    int selectTotalCount();

    List<Department> selectListByPageAndRows(Map<String, Object> map);

    List<Department> find();
}