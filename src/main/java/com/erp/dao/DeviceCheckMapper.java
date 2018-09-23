package com.erp.dao;

import com.erp.bean.DeviceCheck;
import com.erp.bean.device.DeviceCheckVO;

import java.util.HashMap;
import java.util.List;

public interface DeviceCheckMapper {
    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);

    List<DeviceCheckVO> findAllDeviceCheck();

    int  delete_batchDeviceCheck(String[] ids);

    int update_noteDeviceCheck(HashMap hashMap);

    List<DeviceCheckVO> search_deviceCheck_by_deviceName(String searchValue);

    List<DeviceCheckVO> search_deviceCheck_by_deviceCheckId(String searchValue);
}