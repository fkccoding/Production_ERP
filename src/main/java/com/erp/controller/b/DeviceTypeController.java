package com.erp.controller.b;


import com.erp.bean.DeviceType;
import com.erp.bean.device.DeviceTypeList;
import com.erp.bean.device.Message;
import com.erp.service.b.DeviceTypeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;


@Controller
public class DeviceTypeController {

    @Autowired
    DeviceTypeService deviceTypeService;

    @RequestMapping(value={"deviceType/add_judge","deviceType/add"})
    public String add_judgeAndAddDeviceType(){
        return "deviceType_add";
    }
    @RequestMapping("deviceType/insert")
    public @ResponseBody Message insertDeviceType(DeviceType deviceType){
      return deviceTypeService.addDeviceType(deviceType);
    }
    @RequestMapping("deviceType/edit")
    public String EditDeviceType(){
        return "deviceType_edit";
    }
   /* @RequestMapping("deviceType/edit_judge")
    public @ResponseBody Message edit_judgeDeviceType(){
     return null;
    }*/
    @RequestMapping("deviceType/update")
    public @ResponseBody Message updateDeviceType(DeviceType deviceType){
      return deviceTypeService.updateDeviceType(deviceType);
    }
    @RequestMapping("deviceType/delete_judge")
    public String  delete_judgeDeviceType(){
        return "deviceType";
    }
    @RequestMapping("deviceType/delete_batch")
    public @ResponseBody Message delete_batchDeviceType(String[] ids){
       return deviceTypeService.deleteDeciveTypeByIds(ids);
    }
    @RequestMapping("deviceType/get_data")
    public @ResponseBody List<DeviceType> get_dataDeviceType(){
      return   deviceTypeService.get_dataDeviceType();
    }

    @RequestMapping("deviceType/get/{id}")
    public @ResponseBody DeviceType findDeviceTypeById(@PathVariable("id") String id){
        DeviceType deviceTypeById = deviceTypeService.findDeviceTypeById(id);
        return  deviceTypeById;
    }
    @RequestMapping("deviceType/edit_judge")
    public  String edit_judge(){
        return "deviceType_edit";
    }

    @RequestMapping("deviceType/update_all")
    @ResponseBody
    public Message update_all(DeviceType deviceType){
         Message message  = deviceTypeService.update_all(deviceType);
        return message;
    }

    @RequestMapping("device/deviceType")
    public ModelAndView deviceType(ModelAndView modelAndView){
        modelAndView.setViewName("deviceType");
      return modelAndView;
    }
    @RequestMapping("deviceType/list")
    public @ResponseBody DeviceTypeList findAllDeviceType(Integer page,Integer rows ,DeviceType deviceType){
        //PageHelper pageHelper = new PageHelper();

        DeviceTypeList deviceTypeList =  deviceTypeService.findAllDeviceType( page, rows);

        return deviceTypeList;
    }
    @RequestMapping("deviceType/search_deviceType_by_deviceTypeId")
    public @ResponseBody DeviceTypeList search_deviceType_by_deviceTypeId(Integer searchValue,Integer page,Integer rows){

        DeviceTypeList deviceTypeList = deviceTypeService.search_deviceType_by_deviceTypeId(searchValue,page,rows);

        return deviceTypeList;
    }
    @RequestMapping("deviceType/search_deviceType_by_deviceTypeName")
    public @ResponseBody DeviceTypeList search_deviceType_by_deviceTypeName(String searchValue,Integer page,Integer rows){

        DeviceTypeList deviceTypeList = deviceTypeService.search_deviceType_by_deviceTypeName(searchValue,page,rows);

        return deviceTypeList;
    }

}
