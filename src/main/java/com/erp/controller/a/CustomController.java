package com.erp.controller.a;

import com.erp.bean.Custom;
import com.erp.service.a.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/custom")
public class CustomController {

    @Autowired
    CustomService customService;

    /**
     * 显示
     * @return
     */
    @RequestMapping("/find")
    public String find() {
        return "custom_list";
    }
    @RequestMapping("/list")
    @ResponseBody
    public Map list(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();

        int total = customService.getTotalCount();
        List<Custom> customs = customService.selectListByPageAndRows(page, rows);
        map.put("total", total);
        map.put("rows", customs);
        return map;
    }
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Custom get(@PathVariable String id){
        return customService.findById(id);
    }
    @RequestMapping("/get_data")
    @ResponseBody
    public List<Custom> get_data(){
        return customService.selectAll();
    }



    /**
     * 增加
     * @return
     */
    @RequestMapping(value = {"add_judge","add"})
    public String add_judge() {
        return "custom_add";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(Custom custom) {
        Map<String, Object> map = new HashMap<>();
        boolean ok = customService.insert(custom);
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
        return "custom_list";
    }
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map delete_batch(String[] ids){
        Map<String, Object> map = new HashMap<>();
        for (String id : ids) {
            boolean ok = customService.delete(id);
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
        return "custom_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update_all(Custom custom){
        Map<String, Object> map = new HashMap<>();
        boolean update = customService.update(custom);
        if (update) {
            map.put("status",200);
        } else {
            map.put("msg", "修改失败！");
        }
        return map;
    }


    /**
     * 查询
     */
    @RequestMapping("search_custom_by_customId")
    @ResponseBody
    public Map search_custom_by_customId(Integer page, Integer rows,String searchValue){
        Map<String, Object> map = new HashMap<>();
        int total = customService.getCountById(searchValue);
        List<Custom> customs = customService.selectListById(page, rows, searchValue);
        map.put("total", total);
        map.put("rows", customs);
        return map;
    }

    @RequestMapping("search_custom_by_customName")
    @ResponseBody
    public Map search_custom_by_customName(Integer page, Integer rows,String searchValue){
        Map<String, Object> map = new HashMap<>();
        int total = customService.getCountByName(searchValue);
        List<Custom> customs = customService.selectListByName(page, rows, searchValue);
        map.put("total", total);
        map.put("rows", customs);
        return map;
    }

}
