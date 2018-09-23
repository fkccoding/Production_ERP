package com.erp.controller.b;

import com.erp.bean.DeviceFault;
import com.erp.bean.device.DeviceFaultVO;
import com.erp.bean.device.DeviceTList;
import com.erp.bean.device.Message;
import com.erp.service.b.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceFaultController {
    @Autowired
    DeviceFaultService deviceFaultService;

    @RequestMapping("device/deviceFault")
    public String deviceFault(){
        return "deviceFault";
    }

    @RequestMapping("deviceFault/list")
    public @ResponseBody DeviceTList findAllDeviceFault(){
      return   deviceFaultService.findAllDeviceFault();
    }
    @RequestMapping("deviceFault/get_data")
    public @ResponseBody List<DeviceFaultVO> get_dataDeviceFault(){
      return  deviceFaultService.findAllDeviceFaultByget_data();
    }
    @RequestMapping("deviceFault/edit_judge")
    public String edit_judgeDeviceFault(){
        return "deviceFault";
    }
    @RequestMapping("deviceFault/update_note")
    public @ResponseBody Message update_noteDeviceFault(String deviceFaultId,String deviceFaultDetail){
        return deviceFaultService.update_noteDeviceFault(deviceFaultId,deviceFaultDetail);
    }
    @RequestMapping(value={"deviceFault/add_judge","deviceFault/add"})
    public String add_judgeDeviceFault(){
        return "deviceFault_add";
    }
    @RequestMapping("deviceFault/insert")
    public @ResponseBody Message insertDeviceFault(DeviceFault deviceFault){
      return  deviceFaultService.insertDeviceFault(deviceFault);
    }
    @RequestMapping("deviceFault/edit")
    public String editDeviceFault(){
        return "deviceFault_edit";
    }
    @RequestMapping("deviceFault/update")
    public @ResponseBody Message updateDeviceFault(DeviceFault deviceFault,String deviceFaultParams){
        System.out.println(deviceFaultParams);
        return deviceFaultService.updateDeviceFault(deviceFault);
    }
    @RequestMapping("deviceFault/delete_judge")
    public String delete_judgeDeviceFault(){
        return "deviceFault";
    }
    @RequestMapping("deviceFault/delete_batch")
    public @ResponseBody Message delete_batchDeviceFault(String[] ids){
       return deviceFaultService.delete_batchDeviceFault(ids);
    }
    @RequestMapping("deviceFault/get/{id}")
    public @ResponseBody DeviceFault findDeviceFaultById(@PathVariable String id){
       return deviceFaultService.findDeviceFaultById(id);
    }
}
