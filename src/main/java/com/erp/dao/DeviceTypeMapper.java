package com.erp.dao;

import com.erp.bean.Device;
import com.erp.bean.DeviceType;

import java.util.List;

public interface DeviceTypeMapper {
    int deleteByPrimaryKey(String deviceTypeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);

    List<DeviceType> findAllDeviceType();

    List<DeviceType> search_deviceType_by_deviceTypeId(Integer searchValue);

    List<DeviceType> search_deviceType_by_deviceTypeName(String searchValue);

    int addDeviceType(DeviceType deviceType);

    List<DeviceType> get_dataDeviceType();
}