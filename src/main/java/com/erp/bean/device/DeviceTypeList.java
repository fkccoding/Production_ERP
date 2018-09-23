package com.erp.bean.device;

import com.erp.bean.DeviceType;

import java.util.List;

public class DeviceTypeList {
    int total;
    List<DeviceType> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DeviceType> getRows() {
        return rows;
    }

    public void setRows(List<DeviceType> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "DeviceTypeList{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
