package com.erp.service.f;

import com.erp.bean.Department;

import java.util.List;

public interface DepartmentService {
    int getTotalCount();

    List<Department> selectListByPageAndRows(Integer page, Integer rows);

    List<Department> find();

    Department getDepartmentById(String departmentId);
}
