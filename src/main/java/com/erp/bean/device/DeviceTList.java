package com.erp.bean.device;

import java.util.List;

public class DeviceTList {
    int total;
    List<?> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "DeviceTList{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

}
