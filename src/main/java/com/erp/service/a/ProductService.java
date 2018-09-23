package com.erp.service.a;

import com.erp.bean.Product;

import java.util.List;

public interface ProductService {
    Product findById(String id);

    boolean update(Product product);

    int getTotalCount();

    List<Product> selectListByPageAndRows(Integer page, Integer rows);

    List<Product> selectAll();

    List<Product> findByName(String name);

    boolean delete(String id);

    boolean insert(Product product);

    String findIdByName(String searchValue);

    int getCountById(String searchValue);

    List<Product> selectListById(Integer page, Integer rows, String searchValue);

    int getCountByName(String searchValue);

    List<Product> selectListByName(Integer page, Integer rows, String searchValue);

    int getCountByType(String searchValue);

    List<Product> selectListByType(Integer page, Integer rows, String searchValue);
}
