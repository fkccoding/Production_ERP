package com.erp.service.a;

import com.erp.bean.COrder;

import java.util.List;

public interface COrderService {
    public List<COrder> selectListByPageAndRows(Integer page, Integer rows);
    public int getTotalCount();

    boolean updateNote(COrder cOrder);

    boolean insert(COrder cOrder);

    boolean updateAll(COrder cOrder);

    boolean delete(String id);

    COrder findById(String id);

    List selectAll();

    List<COrder> selectListById(Integer page, Integer rows, String orderId);

    int getCountById(String searchValue);

    int getCountByCustomId(String customId);

    List<COrder> selectListByCustomId(Integer page, Integer rows, String customId);

    int getCountByProductId(String productId);

    List<COrder> selectListByProductId(Integer page, Integer rows, String productId);
}
