package com.erp.service.b;

import com.erp.bean.DeviceFault;
import com.erp.bean.device.DeviceFaultVO;
import com.erp.bean.device.DeviceTList;
import com.erp.bean.device.Message;

import java.util.List;

public interface DeviceFaultService {
    DeviceTList findAllDeviceFault();

    List<DeviceFaultVO> findAllDeviceFaultByget_data();

    Message update_noteDeviceFault(String deviceFaultId, String deviceFaultDetail);

    Message insertDeviceFault(DeviceFault deviceFault);

    Message updateDeviceFault(DeviceFault deviceFault);

    Message delete_batchDeviceFault(String[] ids);

    DeviceFault findDeviceFaultById(String id);
}
