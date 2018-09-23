package com.erp.service.a.impl;

import com.erp.bean.COrder;
import com.erp.dao.COrderMapper;
import com.erp.service.a.COrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class COrderServiceImpl implements COrderService{

    @Autowired
    COrderMapper cOrderMapper;

    @Override
    public List<COrder> selectListByPageAndRows(Integer page, Integer rows) {

        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        return cOrderMapper.selectListByPageAndRows(map);
    }

    @Override
    public int getTotalCount() {
        return cOrderMapper.selectTotalCount();
    }

    @Override
    public boolean updateNote(COrder cOrder) {
        return cOrderMapper.updateByPrimaryKeySelective(cOrder)==1;
    }

    @Override
    public boolean insert(COrder cOrder) {
        return cOrderMapper.insert(cOrder)==1;
    }

    @Override
    public boolean updateAll(COrder cOrder) {
        return cOrderMapper.updateByPrimaryKeySelective(cOrder)==1;
    }

    @Override
    public boolean delete(String id) {
        return cOrderMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public COrder findById(String id) {
        return cOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<COrder>  selectAll() {
        return cOrderMapper.selectAll();
    }

    @Override
    public int getCountById(String searchValue) {
        return cOrderMapper.getCountById(searchValue);
    }

    @Override
    public List<COrder> selectListById(Integer page, Integer rows, String orderId) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        map.put("orderId",orderId);
        return cOrderMapper.selectListById(map);
    }

    @Override
    public int getCountByCustomId(String customId) {
        return cOrderMapper.getCountByCustomId(customId);
    }

    @Override
    public List<COrder> selectListByCustomId(Integer page, Integer rows, String customId) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        map.put("customId",customId);
        return cOrderMapper.selectListByCustomId(map);
    }

    @Override
    public int getCountByProductId(String productId) {
        return cOrderMapper.getCountByProductId(productId);
    }

    @Override
    public List<COrder> selectListByProductId(Integer page, Integer rows, String productId) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        map.put("productId",productId);
        return cOrderMapper.selectListByProductId(map);
    }
}
