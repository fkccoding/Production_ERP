package com.erp.service.a.impl;

import com.erp.bean.Custom;
import com.erp.dao.CustomMapper;
import com.erp.service.a.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomServiceImpl implements CustomService{
    @Autowired
    CustomMapper customMapper;

    @Override
    public Custom findById(String id) {
        return customMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(Custom custom) {
        return customMapper.updateByPrimaryKey(custom)==1;
    }

    @Override
    public int getTotalCount() {
        return customMapper.selectTotalCount();
    }

    @Override
    public List<Custom> selectListByPageAndRows(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        return customMapper.selectListByPageAndRows(map);
    }

    @Override
    public List<Custom> selectAll() {
        return customMapper.selectAll();
    }

    @Override
    public boolean insert(Custom custom) {
        return customMapper.insert(custom)==1;
    }

    @Override
    public boolean delete(String id) {
        return customMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean updateAll(Custom custom) {
        return customMapper.updateByPrimaryKeySelective(custom)==1;
    }

    @Override
    public int getCountByName(String searchValue) {
        return customMapper.getCountByName(searchValue);
    }

    @Override
    public List<Custom> selectListByName(Integer page, Integer rows, String searchValue) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        map.put("customName",searchValue);
        return customMapper.selectListByName(map);
    }

    @Override
    public String findIdByName(String searchValue) {
        return customMapper.findIdByName(searchValue);
    }

    @Override
    public int getCountById(String searchValue) {
        return customMapper.getCountById(searchValue);
    }

    @Override
    public List<Custom> selectListById(Integer page, Integer rows, String searchValue) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        map.put("customId",searchValue);
        return customMapper.selectListById(map);
    }
}
