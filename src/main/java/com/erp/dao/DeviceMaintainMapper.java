package com.erp.dao;

import com.erp.bean.DeviceMaintain;
import com.erp.bean.device.DeviceMaintainVO;


import java.util.HashMap;
import java.util.List;

public interface DeviceMaintainMapper {
    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(DeviceMaintain record);

    int insertSelective(DeviceMaintain record);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    int updateByPrimaryKey(DeviceMaintain record);

    List<DeviceMaintainVO> selectAllDeviceMaintainVO();

    int delete_batchDeviceMAintain(String[] ids);

    int update_noteDeviceMaintain(HashMap hashMap);
}