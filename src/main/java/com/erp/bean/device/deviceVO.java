package com.erp.bean.device;

import com.erp.bean.Device;

public class deviceVO extends Device {
    String deviceIdd;//设备种类id
    String deviceTypeName;//设备种类名
    String deviceKeeper;//设备保管者

    public String getDeviceIdd() {
        return deviceIdd;
    }

    public void setDeviceIdd(String deviceIdd) {
        this.deviceIdd = deviceIdd;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceKeeper() {
        return deviceKeeper;
    }
    public void setDeviceKeeper(String deviceKeeper) {
        this.deviceKeeper = deviceKeeper;
    }

    @Override
    public String toString() {
        return "deviceVO{" +
                "deviceIdd='" + deviceIdd + '\'' +
                ", deviceTypeName='" + deviceTypeName + '\'' +
                ", deviceKeeper='" + deviceKeeper + '\'' +
                '}';
    }
}
