package com.erp.service.b.impl;

import com.erp.bean.Device;
import com.erp.bean.DeviceType;
import com.erp.bean.device.DeviceTList;
import com.erp.bean.device.DeviceTypeList;
import com.erp.bean.device.Message;
import com.erp.bean.device.deviceVO;
import com.erp.dao.DeviceMapper;
import com.erp.dao.DeviceTypeMapper;
import com.erp.service.b.DeviceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    @Override
    public DeviceTList findAllDevice(String  page,String rows) {

       DeviceTList deviceTList = new DeviceTList();

       List<Device> devices= deviceMapper.findAllDevice();
        System.out.println(devices);
       if(devices!=null){
           deviceTList.setRows(devices);
           deviceTList.setTotal(devices.size());
       }
        return  deviceTList;
    }

    @Override
    public DeviceTList findAllDeviceVO(String page, String rows) {
      DeviceTList deviceTList = new DeviceTList();
      List<deviceVO>  deviceVOS = deviceMapper.findAllDeviceVOByONETOONE();
      deviceTList.setTotal(deviceVOS.size());
      deviceTList.setRows(deviceVOS);
      return deviceTList;
    }


    @Override
    public Message insertDevice(Device device) {
        Message message = new Message();
        Device device1 = deviceMapper.selectByPrimaryKey(device.getDeviceId());
        if(device1==null){
            int insert = deviceMapper.insert(device);
            if( insert==1){
                message.setStatus(200);
                message.setMsg("OK");
            }
            message.setMsg("系统问题增加失败");
        }
        message.setMsg("用户已经存在，增加失败");
        return  message;
    }

    @Override
    public Message updateDevice(Device device) {
        Message message =new Message();
        String deviceStatusId = device.getDeviceStatusId();
        switch (deviceStatusId){
            case "1":
                device.setDeviceStatus("良好");
                break;
            case "2":
                device.setDeviceStatus("故障");
                break;
            case "3":
                device.setDeviceStatus("维修");
                break;
            case "4":
                device.setDeviceStatus("报废");
                break;

        }
        int i = deviceMapper.updateByPrimaryKey(device);
        if(i==1){
            message.setMsg("OK");
            message.setStatus(200);
        }
        message.setMsg("更新失败");
        return message;
    }
    @Transactional
    @Override
    public Message delete_batchDeviceByIds(String[] ids) {
        int i = 0;
        Message message = new Message();
        for (String id : ids) {
            int delete = deviceMapper.deleteByPrimaryKey(id);
            i++;
        }
        message.setMsg("OK");
        message.setStatus(200);
        return message;
    }

    @Override
    public Message update_noteDevice(String deviceId, String note) {
        HashMap hashMap = new HashMap();
        hashMap.put("deviceId",deviceId);
        hashMap.put("note",note);
        Message message = new Message();
       int update = deviceMapper.update_noteDevice(hashMap);
       if(update==1){
           message.setMsg("更改设备备注成功");
           message.setStatus(200);
       }else{
           message.setMsg("更改设备备注失败");
       }
       return message;
    }

    @Override
    public Device getDeviceById(String id) {
        Device device = deviceMapper.selectByPrimaryKey(id);
        return device;
    }

    @Override
    public List<Device> get_dataDevice() {
        return deviceMapper.get_dataDevice();
    }

    @Override
    public String findIdByName(String searchValue) {
        return deviceMapper.findIdByName(searchValue);
    }
    @Override
    public DeviceTList search_device_by_deviceTypeName(String searchValue, String page, String rows){

        int i = Integer.parseInt(page);
        int j = Integer.parseInt(rows);
        PageHelper.startPage(i,j,true);

        DeviceTList deviceTList = new DeviceTList();

        List<deviceVO> deviceVOS = deviceMapper.search_device_by_deviceTypeName(searchValue);

        PageInfo<deviceVO> pageInfo = new PageInfo<>(deviceVOS);

        deviceTList.setRows(deviceVOS);

        deviceTList.setTotal((int) pageInfo.getTotal());

        return deviceTList;
    }

    @Override
    public DeviceTList search_device_by_deviceName(String searchValue, String page, String rows) {
        int i = Integer.parseInt(page);
        int j = Integer.parseInt(rows);
        PageHelper.startPage(i,j,true);

        DeviceTList deviceTList = new DeviceTList();

        List<deviceVO> deviceVOS = deviceMapper.search_device_by_deviceName(searchValue);

        PageInfo<deviceVO> pageInfo = new PageInfo<>(deviceVOS);

        deviceTList.setRows(deviceVOS);

        deviceTList.setTotal((int) pageInfo.getTotal());

        return deviceTList;

    }

    @Override
    public DeviceTList search_device_by_deviceId(String searchValue, String page, String rows) {

        int i = Integer.parseInt(page);

        int j = Integer.parseInt(rows);

        PageHelper.startPage(i,j,true);

        DeviceTList deviceTList = new DeviceTList();

        List<deviceVO> deviceVOS = deviceMapper.search_device_by_deviceTypeId(searchValue);

        PageInfo<deviceVO> pageInfo = new PageInfo<>(deviceVOS);

        deviceTList.setRows(deviceVOS);

        deviceTList.setTotal((int) pageInfo.getTotal());

        return deviceTList;
    }


}
