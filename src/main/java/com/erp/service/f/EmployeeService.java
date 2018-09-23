package com.erp.service.f;

import com.erp.bean.Employee;

import java.util.List;

public interface EmployeeService {
    int getTotalCount();

    List<Employee> selectListByPageAndRows(Integer page, Integer rows);

    Employee get(String empid);

    int insert(Employee employee);

    int delete(String id);

    int update(Employee employee);
}
