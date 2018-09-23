package com.erp.bean.device;

import com.erp.bean.DeviceCheck;

public class DeviceCheckVO extends DeviceCheck {
   String deviceName;
   String deviceCheckEmp;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceCheckEmp() {
        return deviceCheckEmp;
    }

    public void setDeviceCheckEmp(String deviceCheckEmp) {
        this.deviceCheckEmp = deviceCheckEmp;
    }

    @Override
    public String toString() {
        return "DeviceCheckVO{" +
                "deviceName='" + deviceName + '\'' +
                ", deviceCheckEmp='" + deviceCheckEmp + '\'' +
                '}';
    }
}
