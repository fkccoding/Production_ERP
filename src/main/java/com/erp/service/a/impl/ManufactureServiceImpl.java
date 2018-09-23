package com.erp.service.a.impl;

import com.erp.bean.Manufacture;
import com.erp.dao.ManufactureMapper;
import com.erp.service.a.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManufactureServiceImpl implements ManufactureService{
    @Autowired
    ManufactureMapper manufactureMapper;

    @Override
    public int getTotalCount() {
        return manufactureMapper.selectTotalCount();
    }

    @Override
    public List<Manufacture> selectListByPageAndRows(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", rows);
        map.put("offset", (page - 1) * rows);
        return manufactureMapper.selectListByPageAndRows(map);
    }
}
