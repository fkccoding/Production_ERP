package com.erp.service.b;

import com.erp.bean.Device;
import com.erp.bean.device.DeviceTList;
import com.erp.bean.device.Message;

import java.util.List;

public interface DeviceService {

    DeviceTList findAllDevice(String page, String rows);

    DeviceTList findAllDeviceVO(String page, String rows);

    Message insertDevice(Device device);

    Message updateDevice(Device device);

    Message delete_batchDeviceByIds(String[] ids);

    Message update_noteDevice(String deviceId, String note);

    Device getDeviceById(String id);

    List<Device> get_dataDevice();
    String findIdByName(String searchValue);

    DeviceTList search_device_by_deviceTypeName(String searchValue, String page, String rows);

    DeviceTList search_device_by_deviceName(String searchValue,String page, String rows);

    DeviceTList search_device_by_deviceId(String searchValue, String page, String rows);
}
