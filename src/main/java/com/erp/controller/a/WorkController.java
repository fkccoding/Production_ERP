package com.erp.controller.a;

import com.erp.bean.Work;
import com.erp.service.a.ProductService;
import com.erp.service.a.WorkService;
import com.erp.service.b.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/work")
public class WorkController {

    @Autowired
    WorkService workService;
    @Autowired
    ProductService productService;
    @Autowired
    DeviceService deviceService;

    @RequestMapping("/find")
    public String find() {
        return "work_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map list(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();

        int total = workService.getTotalCount();
        List<Work> works = workService.selectListByPageAndRows(page, rows);
        map.put("total", total);
        map.put("rows", works);
        return map;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Work> get_data(){
        return workService.selectAll();
    }

    /**
     * 增加
     * @return
     */
    @RequestMapping(value = {"add_judge","add"})
    public String add_judge() {
        return "work_add";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(Work work) {
        Map<String, Object> map = new HashMap<>();
        boolean ok = workService.insert(work);
        if (ok) {
            map.put("status", 200);
        } else {
            map.put("msg", "添加失败！");
        }
        return map;
    }



    /**
     * 删除
     * @return
     */
    @RequestMapping("/delete_judge")
    public String delete_judge(){
        return "work_list";
    }
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map delete_batch(String[] ids){
        Map<String, Object> map = new HashMap<>();
        for (String id : ids) {
            boolean ok = workService.delete(id);
            if (ok) {
                map.put("status", 200);
                map.put("msg","删除成功！");
            } else {
                map.put("msg", "删除失败！");
            }
        }
        return map;
    }


    /**
     * 编辑
     * @return
     */
    @RequestMapping(value = {"edit_judge", "edit"})
    public String edit_judge(){
        return "work_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update_all(Work work){
        Map<String, Object> map = new HashMap<>();
        boolean update = workService.update(work);
        if (update) {
            map.put("status",200);
        } else {
            map.put("msg", "修改失败！");
        }
        return map;
    }

    /**
     * 查找
     */
    @RequestMapping("search_work_by_workId")
    @ResponseBody
    public Map search_work_by_workId(Integer page, Integer rows, String searchValue){
        Map<String, Object> map = new HashMap<>();
        int total = workService.getCountById(searchValue);
        List<Work> works = workService.selectListById(page, rows, searchValue);
        map.put("total", total);
        map.put("rows", works);
        return map;
    }

    @RequestMapping("search_work_by_workProduct")
    @ResponseBody
    public Map search_work_by_workProduct(Integer page, Integer rows, String searchValue){
        Map<String, Object> map = new HashMap<>();
        String productId = productService.findIdByName(searchValue);
        int total = workService.getCountByProductId(productId);
        List<Work> works = workService.selectListByProductId(page, rows, productId);
        map.put("total", total);
        map.put("rows", works);
        return map;
    }

    @RequestMapping("search_work_by_workDevice")
    @ResponseBody
    public Map search_work_by_workDevice(Integer page, Integer rows, String searchValue){
        Map<String, Object> map = new HashMap<>();
        //这里有可能会返回多个deviceId，从而服务器内部报错
        String deviceId = deviceService.findIdByName(searchValue);
        int total = workService.getCountByDeviceId(deviceId);
        List<Work> works = workService.selectListByDeviceId(page, rows, deviceId);
        map.put("total", total);
        map.put("rows", works);
        return map;
    }

    @RequestMapping("search_work_by_workProcess")
    @ResponseBody
    public Map search_work_by_workProcess(Integer page, Integer rows, String searchValue){
        Map<String, Object> map = new HashMap<>();
        int total = workService.getCountByProcessId(searchValue);
        List<Work> works = workService.selectListByProcessId(page, rows, searchValue);
        map.put("total", total);
        map.put("rows", works);
        return map;
    }

}
