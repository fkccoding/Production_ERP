package com.erp.controller.b;

import com.erp.bean.DeviceMaintain;
import com.erp.bean.device.DeviceTList;
import com.erp.bean.device.Message;
import com.erp.dao.DeviceMapper;
import com.erp.service.b.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeviceMaintainController {
    @Autowired
    DeviceMaintainService deviceMaintainService;
    @RequestMapping("device/deviceMaintain")
    public String deviceMaintain(){
        return "deviceMaintain";
    }

    @RequestMapping("deviceMaintain/list")
    public @ResponseBody DeviceTList  findAllDeviceMaintain(String page,String rows){
        return deviceMaintainService.findAllDeviceMaintain(page,rows);
    }

    @RequestMapping(value={"deviceMaintain/add","deviceMaintain/add_judge"})
    public String addDeviceMaintain(){
        return "deviceMaintain_add";
    }
    @RequestMapping("deviceMaintain/insert")
    public @ResponseBody Message insertDeviceMaintain(DeviceMaintain deviceMaintain ,String deviceParams){
      return  deviceMaintainService.insertDeviceMaintain(deviceMaintain);
    }
    @RequestMapping(value={"deviceMaintain/edit_judge","deviceMaintain/edit"})
    public String editAndEdit_judge(){
        return "deviceMaintain_edit";
    }
    @RequestMapping("deviceMaintain/update")
    public @ResponseBody Message updateDeviceMaintain(DeviceMaintain deviceMaintain,String deviceMaintainParams){
      return  deviceMaintainService.updateDeviceMaintain(deviceMaintain);
    }

    @RequestMapping("deviceMaintain/delete_judge")
    public String delete_judgeDeviceMaintain(){
        return "deviceMaintain";
    }

    @RequestMapping("deviceMaintain/delete_batch")
    public @ResponseBody Message delete_batchDeviceMAintain(String[] ids){
        return deviceMaintainService.delete_batchDeviceMAintain(ids);
    }

    @RequestMapping("deviceMaintain/update_note")
    public @ResponseBody Message update_noteDeviceMaintain(String deviceMaintainId,String note) {
     return deviceMaintainService.update_noteDeviceMaintain(deviceMaintainId,note);
    }
    }
