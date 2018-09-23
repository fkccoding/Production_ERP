package com.erp.service.a;

import com.erp.bean.Manufacture;

import java.util.List;

public interface ManufactureService {
    int getTotalCount();

    List<Manufacture> selectListByPageAndRows(Integer page, Integer rows);
}
