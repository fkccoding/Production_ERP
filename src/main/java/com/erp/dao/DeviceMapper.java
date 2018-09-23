package com.erp.dao;

import com.erp.bean.Device;
import com.erp.bean.device.deviceVO;

import java.util.HashMap;
import java.util.List;

public interface DeviceMapper {
    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

    List<Device> findAllDevice();

    List<deviceVO> findAllDeviceVO();

    int update_noteDevice(HashMap hashMap);

    Device findAllDeviceByDeviceId(String deviceId);

    List<Device> get_dataDevice();

    String findIdByName(String searchValue);

    List<deviceVO> findAllDeviceVOByONETOONE();

    List<deviceVO> search_device_by_deviceTypeName(String searchValue);

    List<deviceVO> search_device_by_deviceTypeId(String searchValue);

    List<deviceVO> search_device_by_deviceName(String searchValue);
}