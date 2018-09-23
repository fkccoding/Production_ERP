package com.erp.service.a.impl;

import com.erp.bean.Work;
import com.erp.dao.WorkMapper;
import com.erp.service.a.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkServiceImpl implements WorkService{
    @Autowired
    WorkMapper workMapper;

    @Override
    public int getTotalCount() {
        return workMapper.selectTotalCount();
    }

    @Override
    public List<Work> selectListByPageAndRows(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        return workMapper.selectListByPageAndRows(map);
    }

    @Override
    public boolean insert(Work work) {
        return workMapper.insert(work)==1;
    }

    @Override
    public boolean delete(String id) {
        return workMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(Work work) {
        return workMapper.updateByPrimaryKeySelective(work)==1;
    }

    @Override
    public List<Work> selectAll() {
        return workMapper.selectAll();
    }

    @Override
    public Work findById(String id) {
        return workMapper.selectByPrimaryKey(id);
    }

    @Override
    public int getCountById(String searchValue) {
        return workMapper.getCountById(searchValue);
    }

    @Override
    public List<Work> selectListById(Integer page, Integer rows, String searchValue) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        map.put("workId",searchValue);
        return workMapper.selectListById(map);
    }

    @Override
    public int getCountByProductId(String productId) {
        return workMapper.getCountByProductId(productId);
    }

    @Override
    public List<Work> selectListByProductId(Integer page, Integer rows, String productId) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        map.put("productId",productId);
        return workMapper.selectListByProductId(map);
    }

    @Override
    public int getCountByProcessId(String searchValue) {
        return workMapper.getCountByProcessId(searchValue);
    }

    @Override
    public List<Work> selectListByProcessId(Integer page, Integer rows, String searchValue) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        map.put("processId",searchValue);
        return workMapper.selectListByProcessId(map);
    }

    @Override
    public int getCountByDeviceId(String deviceId) {
        return workMapper.getCountByDeviceId(deviceId);
    }

    @Override
    public List<Work> selectListByDeviceId(Integer page, Integer rows, String deviceId) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        map.put("deviceId",deviceId);
        return workMapper.selectListByDeviceId(map);
    }
}
