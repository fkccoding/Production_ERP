package com.erp.service.b.impl;

import com.erp.bean.DeviceType;
import com.erp.bean.device.DeviceTypeList;
import com.erp.bean.device.Message;
import com.erp.dao.DeviceTypeMapper;
import com.erp.service.b.DeviceTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;
    @Override
    public DeviceTypeList findAllDeviceType(Integer page,Integer rows) {

        PageHelper.startPage(page, rows, true);

        DeviceTypeList deviceTypeList = new DeviceTypeList();

        List<DeviceType> deviceTypes = deviceTypeMapper.findAllDeviceType();
        System.out.println("deviceTypesBefore=" + deviceTypes);
        PageInfo<DeviceType> pageInfo = new PageInfo<>(deviceTypes);
        System.out.println(deviceTypes);

        if (deviceTypes != null) {

            deviceTypeList.setRows(deviceTypes);

            deviceTypeList.setTotal((int) pageInfo.getTotal());
        }
        System.out.println(deviceTypeList);

        return deviceTypeList;
    }

    @Override
    public DeviceTypeList search_deviceType_by_deviceTypeId(Integer searchValue, Integer page, Integer rows) {
        PageHelper.startPage(page,rows,true);
        DeviceTypeList deviceTypeList = new DeviceTypeList();
        List<DeviceType>  deviceTypes = deviceTypeMapper.search_deviceType_by_deviceTypeId(searchValue);

        PageInfo<DeviceType> deviceTypePageInfo = new PageInfo<>(deviceTypes);

        System.out.println(deviceTypes);

        if(deviceTypes!=null){

            deviceTypeList.setRows(deviceTypes);

            deviceTypeList.setTotal((int) deviceTypePageInfo.getTotal());
        }
        System.out.println(deviceTypeList);

        return deviceTypeList;
    }

    @Override
    public DeviceTypeList search_deviceType_by_deviceTypeName(String searchValue, Integer page, Integer rows) {
        DeviceTypeList deviceTypeList = new DeviceTypeList();
        List<DeviceType>  deviceTypes = deviceTypeMapper.search_deviceType_by_deviceTypeName(searchValue);
        System.out.println(deviceTypes);

        if(deviceTypes!=null){

            deviceTypeList.setRows(deviceTypes);

            deviceTypeList.setTotal(deviceTypes.size());
        }
        System.out.println(deviceTypeList);

        return deviceTypeList;
    }


    public Message addDeviceType(DeviceType deviceType){
     Message message =new Message();
      //先去通过id查询存不存在
        DeviceType selectByPrimaryKey= deviceTypeMapper.selectByPrimaryKey(deviceType.getDeviceTypeId());
        //若不存在则插入
        if(selectByPrimaryKey==null){
            int addNum =  deviceTypeMapper.insertSelective(deviceType);
            //若插入成功返回flag变为true
            if(addNum==1){
               message.setMsg("添加设备种类成功");
               message.setStatus(200);
        }
        message.setMsg("插入失败！");
      }
        message.setMsg("该设备种类编号已经存在，请更换设备种类编号！");
        return   message;
    }

    @Override
    public Message updateDeviceType(DeviceType deviceType) {

        Message message =new Message();

        int  update= deviceTypeMapper.updateByPrimaryKeySelective(deviceType);
        if(update==1){
            message.setMsg("更新设备种类成功");
            message.setStatus(200);
        }else {
            message.setMsg("更新设备种类失败");
        }
        return  message;
    }
    @Transactional
    @Override
    public Message deleteDeciveTypeByIds(String[] ids) {
        Message message =new Message();
        for (String id:ids) {
          deviceTypeMapper.deleteByPrimaryKey(id);

        }
       message.setMsg("删除成功");
       message.setStatus(200);
       return  message;
    }

    @Override
    public DeviceType findDeviceTypeById(String id) {
        DeviceType deviceType = deviceTypeMapper.selectByPrimaryKey(id);
        return deviceType;
    }

    @Override
    public Message update_all(DeviceType devicetype) {

        Message message = new Message();
        int i = deviceTypeMapper.updateByPrimaryKey(devicetype);
        if(i==1){
           message.setStatus(200);
           message.setMsg("OK");
        }
        return message;
    }

    @Override
    public List<DeviceType> get_dataDeviceType() {
        List<DeviceType> deviceTypes = deviceTypeMapper.get_dataDeviceType();
        if (deviceTypes!=null){
            return deviceTypes;
        }
        return null;
    }

    @Override
    public Message edit_judgeDeviceType() {
        Message message = new Message();
         message.setData("1000");
        return  message;
    }

}
