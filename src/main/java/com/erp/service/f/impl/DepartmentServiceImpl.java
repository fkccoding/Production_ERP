package com.erp.service.f.impl;

import com.erp.bean.Department;
import com.erp.dao.DepartmentMapper;
import com.erp.service.f.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public int getTotalCount() {
        return departmentMapper.selectTotalCount();
    }

    @Override
    public List<Department> selectListByPageAndRows(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        return departmentMapper.selectListByPageAndRows(map);
    }

    @Override
    public List<Department> find() {
        return departmentMapper.find();
    }

    @Override
    public Department getDepartmentById(String departmentId) {
        return departmentMapper.selectByPrimaryKey(departmentId);
    }
}
