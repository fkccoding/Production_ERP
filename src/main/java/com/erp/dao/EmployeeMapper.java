package com.erp.dao;

import com.erp.bean.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String empId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    int selectTotalCount();

    List<Employee> selectListByPageAndRows(Map<String, Object> map);

    Employee get(String empid);

}
