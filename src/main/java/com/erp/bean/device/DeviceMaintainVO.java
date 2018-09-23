package com.erp.bean.device;

import com.erp.bean.DeviceMaintain;

public class DeviceMaintainVO extends DeviceMaintain {
    String deviceMaintainEmp;

    public String getDeviceMaintainEmp() {
        return deviceMaintainEmp;
    }

    public void setDeviceMaintainEmp(String deviceMaintainEmp) {
        this.deviceMaintainEmp = deviceMaintainEmp;
    }

    @Override
    public String toString() {
        return "DeviceMaintainVO{" +
                "deviceMaintainEmp='" + deviceMaintainEmp + '\'' +
                '}';
    }
}
