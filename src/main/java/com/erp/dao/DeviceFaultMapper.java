package com.erp.dao;

import com.erp.bean.DeviceFault;

import java.util.HashMap;
import java.util.List;

public interface DeviceFaultMapper {
    int deleteByPrimaryKey(String deviceFaultId);

    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByPrimaryKeySelective(DeviceFault record);

    int updateByPrimaryKey(DeviceFault record);

    List<DeviceFault> findAllDeviceFault();

    int update_noteDeviceFault(HashMap hashMap);

    int delete_batchDeviceFault(String[] ids);
}