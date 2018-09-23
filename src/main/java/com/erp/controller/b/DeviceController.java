package com.erp.controller.b;

import com.erp.bean.Device;
import com.erp.bean.device.DeviceTList;
import com.erp.bean.device.Message;
import com.erp.service.b.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceController {
    @Autowired
    DeviceService deviceService;
    @RequestMapping("deviceList/delete_judge")
    public String delete_judgeDevice(){
        return "deviceList";
    }
    @RequestMapping("deviceList/delete_batch")
    public@ResponseBody Message delete_batchDeviceByIds(String[] ids){

        Message message = deviceService.delete_batchDeviceByIds(ids);

        return message;
    }
    @RequestMapping(value={"deviceList/edit_judge","deviceList/edit"})
    public String editJudgeAndEditDevice(){
        return "deviceList_edit";
    }
    @RequestMapping("deviceList/update")
    public @ResponseBody Message updateDevice(Device device){
        System.out.println("Device="+device);
       Message message = deviceService.updateDevice(device);
       return message;
    }
    @RequestMapping("deviceList/insert")
    public @ResponseBody Message insertDevice(Device device){

     Message message =   deviceService.insertDevice(device);
     return  message;

    }
    @RequestMapping(value = {"deviceList/add_judge","deviceList/add"})
    public String add_judgeAndAddDevice(){
        return "deviceList_add";
    }
    @RequestMapping("device/deviceList")
    public String device(){
        return "deviceList";
    }
    @RequestMapping("deviceList/update_note")
    public @ResponseBody Message update_noteDevice(String deviceId,String note){

      Message message = deviceService.update_noteDevice(deviceId,note);

      return message;
    }
    @RequestMapping("deviceList/list")
    public @ResponseBody DeviceTList findAllDevice( String page, String rows){
        DeviceTList allDeviceVO = deviceService.findAllDeviceVO(page,rows);
        return  allDeviceVO;
    }
    @RequestMapping("deviceList/get/{id}")
    public @ResponseBody Device getDeviceById(@PathVariable String id){
       return deviceService.getDeviceById(id);
    }
    @RequestMapping("deviceList/update_all")
    public @ResponseBody Message update_allDevice(Device device){
        Message message = deviceService.updateDevice(device);
        return message;
    }
    @RequestMapping("deviceList/get_data")
    public @ResponseBody List<Device> get_dataDevice(){
       return deviceService.get_dataDevice();
    }
    @RequestMapping("deviceList/search_device_by_deviceId")
    public @ResponseBody DeviceTList search_device_by_deviceId(String searchValue,String page,String rows){
        return deviceService.search_device_by_deviceId(searchValue,page,rows);
    }
    @RequestMapping("deviceList/search_device_by_deviceName")
    public @ResponseBody DeviceTList search_device_by_deviceName(String searchValue,String page,String rows){
        return deviceService.search_device_by_deviceName(searchValue,page,rows);
    }
    @RequestMapping("deviceList/search_device_by_deviceTypeName")
    public @ResponseBody DeviceTList search_device_by_deviceTypeName(String searchValue,String page,String rows){
        return deviceService.search_device_by_deviceTypeName(searchValue,page,rows);
    }
}
