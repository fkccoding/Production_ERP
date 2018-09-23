package com.erp.service.b;

import com.erp.bean.DeviceCheck;
import com.erp.bean.device.DeviceTList;
import com.erp.bean.device.Message;

public interface DeviceCheckService {
    DeviceTList findAllDeviceCheck();

    Message insertDeviceCheck(DeviceCheck deviceCheck);

    Message updateDeviceCheck(DeviceCheck deviceCheck);

    Message delete_batchDeviceCheck(String[] ids);

    Message update_noteDeviceCheck(String deviceCheckId, String deviceCheckResult);

    DeviceTList search_deviceCheck_by_deviceName(String searchValue, Integer page, Integer rows);

    DeviceTList search_deviceCheck_by_deviceCheckId(String searchValue, Integer page, Integer rows);
}
