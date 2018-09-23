package com.erp.service.b.impl;


import com.erp.bean.DeviceMaintain;
import com.erp.bean.device.DeviceMaintainVO;
import com.erp.bean.device.DeviceTList;
import com.erp.bean.device.Message;
import com.erp.dao.DeviceMaintainMapper;
import com.erp.service.b.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {
    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;
    @Override
    public DeviceTList findAllDeviceMaintain(String page, String rows) {
      DeviceTList deviceTList = new DeviceTList();
      List<DeviceMaintainVO> deviceMaintainVOS = deviceMaintainMapper.selectAllDeviceMaintainVO();
        deviceTList.setRows(deviceMaintainVOS);
        deviceTList.setTotal(deviceMaintainVOS.size());
      return deviceTList;
    }

    @Override
    public Message insertDeviceMaintain(DeviceMaintain deviceMaintain) {
        DeviceMaintain deviceMaintainSelect = deviceMaintainMapper.selectByPrimaryKey(deviceMaintain.getDeviceMaintainId());
        Message message = new Message();
        if(deviceMaintainSelect==null){
            int insert = deviceMaintainMapper.insert(deviceMaintain);
            if(insert==1) {
                message.setMsg("OK");
                message.setStatus(200);
            }
            message.setMsg("系统出错");
        }
        message.setMsg("该设备维修编号已经存在，请更换设备维修编号!");
        return message;
    }

    @Override
    public Message updateDeviceMaintain(DeviceMaintain deviceMaintain) {
        int i = deviceMaintainMapper.updateByPrimaryKey(deviceMaintain);
        Message message = new Message();
        if(i==1){
            message.setMsg("OK");
            message.setStatus(200);
        }
        message.setMsg("更改失败");
        return message;
    }
    @Transactional
    @Override
    public Message delete_batchDeviceMAintain(String[] ids) {
        Message message = new Message();
       int delete = deviceMaintainMapper.delete_batchDeviceMAintain(ids);
       if(delete==ids.length){
           message.setMsg("OK");
           message.setStatus(200);
       }
       message.setMsg("删除失败");
       return message;
    }

    @Override
    public Message update_noteDeviceMaintain(String deviceMaintainId, String note) {
        HashMap hashMap = new HashMap();
        hashMap.put("deviceMaintainId",deviceMaintainId);
        hashMap.put("note",note);
        Message message = new Message();
        int update = deviceMaintainMapper.update_noteDeviceMaintain(hashMap);
        if (update == 1) {
            message.setMsg("OK");
            message.setStatus(200);
        }
        message.setMsg("更新设备维修备注失败");
        return message;
    }

}
