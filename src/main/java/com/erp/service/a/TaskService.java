package com.erp.service.a;

import com.erp.bean.Task;

import java.util.List;

public interface TaskService {
    int getTotalCount();

    List<Task> selectListByPageAndRows(Integer page, Integer rows);

    Task findById(String id);

    List<Task> selectAll();

    boolean insert(Task task);

    boolean delete(String id);

    boolean update(Task task);

    int getCountById(String searchValue);

    List<Task> selectListById(Integer page, Integer rows, String searchValue);

    int getCountByWorkId(String searchValue);

    List<Task> selectListByWorkId(Integer page, Integer rows, String searchValue);

    int getCountByManufactureSn(String searchValue);

    List<Task> selectListByManufactureSn(Integer page, Integer rows, String searchValue);
}
