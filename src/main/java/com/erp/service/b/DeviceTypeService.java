package com.erp.service.b;

import com.erp.bean.DeviceType;
import com.erp.bean.device.DeviceTypeList;
import com.erp.bean.device.Message;

import java.util.List;

public interface DeviceTypeService {

    DeviceTypeList findAllDeviceType(Integer page,Integer rows);

    DeviceTypeList search_deviceType_by_deviceTypeId(Integer searchValue, Integer page, Integer rows);

    DeviceTypeList search_deviceType_by_deviceTypeName(String searchValue, Integer page, Integer rows);

    Message addDeviceType(DeviceType deviceType);

    Message updateDeviceType(DeviceType deviceType);

    Message deleteDeciveTypeByIds(String[] ids);

    DeviceType findDeviceTypeById(String id);

    Message update_all(DeviceType devicetype);

    List<DeviceType> get_dataDeviceType();

    Message edit_judgeDeviceType();
}
