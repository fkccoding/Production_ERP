package com.erp.controller.b;

import com.erp.bean.DeviceCheck;
import com.erp.bean.device.DeviceTList;
import com.erp.bean.device.Message;
import com.erp.service.b.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeviceCheckController {

    @Autowired
    DeviceCheckService deviceCheckService;

    @RequestMapping("device/deviceCheck")
    public String deviceCheck() {
        return "deviceCheck";
    }

    @RequestMapping("deviceCheck/list")
    public @ResponseBody DeviceTList findAllDeviceCheck() {
    return deviceCheckService.findAllDeviceCheck();
    }

   @RequestMapping("deviceCheck/add_judge")
    public String add_judgeDeviceCheck(){
        return "deviceCheck_add";
    }

    @RequestMapping("deviceCheck/add")
    public String addDeviceCheck(){
        return "deviceCheck_add";
    }
    @RequestMapping("deviceCheck/insert")
    public @ResponseBody Message insertDeviceCheck(DeviceCheck deviceCheck,String deviceParams){
     return   deviceCheckService.insertDeviceCheck(deviceCheck);
    }

    @RequestMapping(value={"deviceCheck/edit","deviceCheck/edit_judge"})
    public String editAndEdit_judge(){
        return "deviceCheck_edit";
    }
    @RequestMapping("deviceCheck/update")
    public @ResponseBody Message updateDeviceCheck(DeviceCheck deviceCheck,String deviceCheckParams){
      return  deviceCheckService.updateDeviceCheck(deviceCheck);
    }
    @RequestMapping("deviceCheck/delete_judge")
    public String delete_judegeDeviceCheck(){
        return "deviceCheck";
    }
    @RequestMapping("deviceCheck/delete_batch")
    public @ResponseBody Message delete_batchDeviceCheck(String[] ids){
        return deviceCheckService.delete_batchDeviceCheck(ids);
    }

    @RequestMapping("deviceCheck/update_note")
    public @ResponseBody Message update_noteDeviceCheck(String deviceCheckId,String deviceCheckResult){
     return deviceCheckService.update_noteDeviceCheck(deviceCheckId,deviceCheckResult);
    }
    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceName")
    public @ResponseBody DeviceTList search_deviceCheck_by_deviceName(String searchValue,Integer page,Integer rows){
        return deviceCheckService.search_deviceCheck_by_deviceName(searchValue,page,rows);
    }
    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceCheckId")
    public @ResponseBody DeviceTList search_deviceCheck_by_deviceCheckId(String searchValue,Integer page,Integer rows){
        return deviceCheckService.search_deviceCheck_by_deviceCheckId(searchValue,page,rows);
    }
}
