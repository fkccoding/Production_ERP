package com.erp.service.a.impl;

import com.erp.bean.Task;
import com.erp.dao.TaskMapper;
import com.erp.service.a.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskMapper taskMapper;

    @Override
    public int getTotalCount() {
        return taskMapper.getTotalCount();
    }

    @Override
    public List<Task> selectListByPageAndRows(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        return taskMapper.selectListByPageAndRows(map);
    }

    @Override
    public Task findById(String id) {
        return taskMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Task> selectAll() {
        return taskMapper.selectAll();
    }

    @Override
    public boolean insert(Task task) {
        return taskMapper.insert(task)==1;
    }

    @Override
    public boolean delete(String id) {
        return taskMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(Task task) {
        return taskMapper.updateByPrimaryKeySelective(task)==1;
    }

    @Override
    public int getCountById(String searchValue) {
        return taskMapper.getCountById(searchValue);
    }

    @Override
    public List<Task> selectListById(Integer page, Integer rows, String searchValue) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        map.put("taskId",searchValue);
        return taskMapper.selectListById(map);
    }

    @Override
    public int getCountByWorkId(String searchValue) {
        return taskMapper.getCountByWorkId(searchValue);
    }

    @Override
    public List<Task> selectListByWorkId(Integer page, Integer rows, String searchValue) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        map.put("workId",searchValue);
        return taskMapper.selectListByWorkId(map);
    }

    @Override
    public int getCountByManufactureSn(String searchValue) {
        return taskMapper.getCountByManufactureSn(searchValue);
    }

    @Override
    public List<Task> selectListByManufactureSn(Integer page, Integer rows, String searchValue) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        map.put("manufactureSn",searchValue);
        return taskMapper.selectListByManufactureSn(map);
    }
}
