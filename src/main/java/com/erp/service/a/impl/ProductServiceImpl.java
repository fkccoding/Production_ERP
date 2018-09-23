package com.erp.service.a.impl;

import com.erp.bean.Product;
import com.erp.dao.ProductMapper;
import com.erp.service.a.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductMapper productMapper;

    @Override
    public Product findById(String id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(Product product) {
        return productMapper.updateByPrimaryKey(product)==1;
    }

    @Override
    public int getTotalCount() {
        return productMapper.selectTotalCount();
    }

    @Override
    public List<Product> selectListByPageAndRows(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        return productMapper.selectListByPageAndRows(map);
    }

    @Override
    public List<Product> selectAll() {
        return productMapper.selectAll();
    }

    @Override
    public List<Product> findByName(String name) {
        return productMapper.selectByName(name);
    }

    @Override
    public boolean insert(Product product) {
        return productMapper.insert(product)==1;
    }

    @Override
    public boolean delete(String id) {
        return productMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public String findIdByName(String searchValue) {
        return productMapper.findIdByName(searchValue);
    }

    @Override
    public int getCountById(String searchValue) {
        return productMapper.getCountById(searchValue);
    }

    @Override
    public List<Product> selectListById(Integer page, Integer rows, String searchValue) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        map.put("productId",searchValue);
        return productMapper.selectListById(map);
    }

    @Override
    public int getCountByName(String searchValue) {
        return productMapper.getCountByName(searchValue);
    }

    @Override
    public List<Product> selectListByName(Integer page, Integer rows, String searchValue) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        map.put("productName",searchValue);
        return productMapper.selectListByName(map);
    }

    @Override
    public int getCountByType(String searchValue) {
        return productMapper.getCountByType(searchValue);
    }

    @Override
    public List<Product> selectListByType(Integer page, Integer rows, String searchValue) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        map.put("productType",searchValue);
        return productMapper.selectListByType(map);
    }
}
