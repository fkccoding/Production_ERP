package com.erp.service.f.impl;

import com.erp.bean.Employee;
import com.erp.dao.EmployeeMapper;
import com.erp.service.f.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public int getTotalCount() {
        return employeeMapper.selectTotalCount();
    }

    @Override
    public List<Employee> selectListByPageAndRows(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        return employeeMapper.selectListByPageAndRows(map);
    }

    @Override
    public Employee get(String id) {
        return employeeMapper.get(id);
    }

    @Override
    public int insert(Employee employee) {
        return employeeMapper.insert(employee);
    }

    @Override
    public int delete(String id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }
}
