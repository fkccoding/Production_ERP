package com.erp.service.b;

import com.erp.bean.DeviceMaintain;
import com.erp.bean.device.DeviceTList;
import com.erp.bean.device.Message;

public interface DeviceMaintainService {
    DeviceTList findAllDeviceMaintain(String page, String rows);

    Message insertDeviceMaintain(DeviceMaintain deviceMaintain);

    Message updateDeviceMaintain(DeviceMaintain deviceMaintain);

    Message delete_batchDeviceMAintain(String[] ids);

    Message update_noteDeviceMaintain(String deviceMaintainId, String note);
}
