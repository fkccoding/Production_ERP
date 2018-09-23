package com.erp.service.b.impl;

import com.erp.bean.Device;
import com.erp.bean.DeviceFault;
import com.erp.bean.DeviceType;
import com.erp.bean.device.DeviceFaultVO;
import com.erp.bean.device.DeviceTList;
import com.erp.bean.device.Message;
import com.erp.dao.DeviceFaultMapper;
import com.erp.dao.DeviceMapper;
import com.erp.dao.DeviceTypeMapper;
import com.erp.service.b.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {
    @Autowired
    DeviceFaultMapper deviceFaultMapper;
    @Autowired
    DeviceTypeMapper deviceTypeMapper;
    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public DeviceTList findAllDeviceFault() {
    DeviceTList deviceTList =new  DeviceTList();

    List<DeviceFaultVO> deviceFaultVOS =new ArrayList<>();
    List<DeviceFault> deviceFaults = deviceFaultMapper.findAllDeviceFault();
        for (DeviceFault deviceFault:deviceFaults) {
         Device device  = deviceMapper.findAllDeviceByDeviceId(deviceFault.getDeviceId());
         System.out.println(device);
         DeviceFaultVO deviceFaultVO =new DeviceFaultVO();
         deviceFaultVO.setDeviceName(device.getDeviceName());
         deviceFaultVO.setDeviceId(deviceFault.getDeviceId());
         deviceFaultVO.setDeviceFaultCause(deviceFault.getDeviceFaultCause());
         deviceFaultVO.setDeviceFaultDate(deviceFault.getDeviceFaultDate());
         deviceFaultVO.setDeviceFaultDetail(deviceFault.getDeviceFaultDetail());
         deviceFaultVO.setDeviceFaultId(deviceFault.getDeviceFaultId());
         deviceFaultVO.setDeviceFaultMaintenance(deviceFault.getDeviceFaultMaintenance());
            System.out.println("findAllDeviceFault="+deviceFaultVO);
         deviceFaultVOS.add(deviceFaultVO);
        }

    deviceTList.setTotal(deviceFaults.size());
    deviceTList.setRows(deviceFaultVOS);
    return deviceTList;
    }

    @Override
    public List<DeviceFaultVO> findAllDeviceFaultByget_data() {
        List<DeviceFaultVO> deviceFaultVOS = new ArrayList<>();
        List<DeviceFault> deviceFaults = deviceFaultMapper.findAllDeviceFault();
        for (DeviceFault deviceFault:deviceFaults){
            DeviceFaultVO deviceFaultVO =new DeviceFaultVO();
            deviceFaultVO.setDeviceId(deviceFault.getDeviceId());
            deviceFaultVO.setDeviceFaultCause(deviceFault.getDeviceFaultCause());
            deviceFaultVO.setDeviceFaultDate(deviceFault.getDeviceFaultDate());
            deviceFaultVO.setDeviceFaultDetail(deviceFault.getDeviceFaultDetail());
            deviceFaultVO.setDeviceFaultId(deviceFault.getDeviceFaultId());
            deviceFaultVO.setDeviceFaultMaintenance(deviceFault.getDeviceFaultMaintenance());
            deviceFaultVOS.add((DeviceFaultVO) deviceFault);
            deviceFaultVOS.add(deviceFaultVO);
        }
        return deviceFaultVOS;
    }

    @Override
    public Message update_noteDeviceFault(String deviceFaultId, String deviceFaultDetail) {
        HashMap hashMap = new HashMap();
        hashMap.put("deviceFaultId",deviceFaultId);
        hashMap.put("deviceFaultDetail",deviceFaultDetail);
        Message message = new Message();
        int update = deviceFaultMapper.update_noteDeviceFault(hashMap);
        if(update==1){
            message.setMsg("OK");
            message.setStatus(200);
        }
        message.setMsg("更新失败");
        return message;
    }

    @Override
    public Message insertDeviceFault(DeviceFault deviceFault) {
        Message message = new Message();
        DeviceFault deviceFaults = deviceFaultMapper.selectByPrimaryKey(deviceFault.getDeviceFaultId());
        if(deviceFaults==null){
            int insert = deviceFaultMapper.insert(deviceFault);
            if(insert==1){
                message.setMsg("OK");
                message.setStatus(200);
            }
            message.setMsg("系统出错,请重新填写信息");
        }else {
            message.setMsg("该设备故障编号已经存在，请更换设备故障编号！");
        }
        return message;
    }

    @Override
    public Message updateDeviceFault(DeviceFault deviceFault) {
        int i = deviceFaultMapper.updateByPrimaryKey(deviceFault);
        Message message = new Message();
        if(i==1){
            message.setMsg("OK");
            message.setStatus(200);
        }
        message.setMsg("更新故障失败");
        return  message;
    }

    @Transactional
    @Override
    public Message delete_batchDeviceFault(String[] ids) {
        int i = deviceFaultMapper.delete_batchDeviceFault(ids);
        System.out.println("delete_batchDeviceFault="+i);
        Message message =new Message();
       if(i==ids.length){
           message.setMsg("OK");
           message.setStatus(200);
       }else{
           message.setMsg("删除失败");
           int j=1/0;
       }
       return message;
    }

    @Override
    public DeviceFault findDeviceFaultById(String id) {
        DeviceFault deviceFault = deviceFaultMapper.selectByPrimaryKey(id);
        return deviceFault;
    }
}
