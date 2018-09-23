package com.erp.service.b.impl;

import com.erp.bean.DeviceCheck;
import com.erp.bean.device.DeviceCheckVO;
import com.erp.bean.device.DeviceTList;
import com.erp.bean.device.Message;
import com.erp.dao.DeviceCheckMapper;
import com.erp.service.b.DeviceCheckService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {
    @Autowired
    DeviceCheckMapper deviceCheckMapper;
    @Override
    public DeviceTList findAllDeviceCheck() {
       List<DeviceCheckVO> deviceCheckVOS = deviceCheckMapper.findAllDeviceCheck();
       DeviceTList deviceTList = new DeviceTList();
       deviceTList.setTotal(deviceCheckVOS.size());
       deviceTList.setRows(deviceCheckVOS);
        return  deviceTList;
    }

    @Override
    public Message insertDeviceCheck(DeviceCheck deviceCheck) {
        DeviceCheck deviceCheck1 = deviceCheckMapper.selectByPrimaryKey(deviceCheck.getDeviceCheckId());
        Message message = new Message();
        if(deviceCheck1==null) {
            int insert = deviceCheckMapper.insert(deviceCheck);
            if (insert == 1) {
                message.setMsg("OK");
                message.setStatus(200);
            } else {
                message.setMsg("系统出错插入失败");
            }
        }else{
            message.setMsg("该设备例检编号已经存在，请更换设备例检编号！");
        }
        return message;
    }

    @Override
    public Message updateDeviceCheck(DeviceCheck deviceCheck) {
        int i = deviceCheckMapper.updateByPrimaryKey(deviceCheck);
        Message message = new Message();
        if(i==1){
            message.setMsg("OK");
            message.setStatus(200);
        }else{
            message.setMsg("更改失败");
        }
        return message;
    }
    @Transactional
    @Override
    public Message delete_batchDeviceCheck(String[] ids) {
      int delete =  deviceCheckMapper.delete_batchDeviceCheck(ids);
      Message message = new Message();
      if(delete==ids.length){
          message.setMsg("OK");
          message.setStatus(200);
      }else{
          message.setMsg("删除失败");
          int j =1/0;
      }
        return message;
    }

    @Override
    public Message update_noteDeviceCheck(String deviceCheckId, String deviceCheckResult) {
        HashMap hashMap = new HashMap();
        hashMap.put("deviceCheckId",deviceCheckId);
        hashMap.put("deviceCheckResult",deviceCheckResult);
        Message message =new Message();
     int updateDeviceCheckNote  = deviceCheckMapper.update_noteDeviceCheck(hashMap);
     if(updateDeviceCheckNote==1){
         message.setMsg("OK");
         message.setStatus(200);
     }
     message.setMsg("更改失败");
     return  message;
    }

    @Override
    public DeviceTList search_deviceCheck_by_deviceName(String searchValue, Integer page, Integer rows) {
        PageHelper.startPage(page,rows,true);
        DeviceTList deviceTList = new DeviceTList();
        List<DeviceCheckVO> deviceCheckVOS = deviceCheckMapper.search_deviceCheck_by_deviceName(searchValue);
        PageInfo<DeviceCheckVO> deviceCheckVOPageInfo =new PageInfo<>(deviceCheckVOS);
        deviceTList.setRows(deviceCheckVOS);
        deviceTList.setTotal((int) deviceCheckVOPageInfo.getTotal());
        return  deviceTList;
    }

    @Override
    public DeviceTList search_deviceCheck_by_deviceCheckId(String searchValue, Integer page, Integer rows) {
        PageHelper.startPage(page,rows,true);
        DeviceTList deviceTList = new DeviceTList();
        List<DeviceCheckVO> deviceCheckVOS = deviceCheckMapper.search_deviceCheck_by_deviceCheckId(searchValue);
        PageInfo<DeviceCheckVO> deviceCheckVOPageInfo =new PageInfo<>(deviceCheckVOS);
        deviceTList.setRows(deviceCheckVOS);
        deviceTList.setTotal((int) deviceCheckVOPageInfo.getTotal());
        return  deviceTList;
    }
}
