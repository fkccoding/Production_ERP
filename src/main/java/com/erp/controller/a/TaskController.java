package com.erp.controller.a;

import com.erp.bean.Task;
import com.erp.service.a.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    /**
     * 显示
     * @return
     */
    @RequestMapping("/find")
    public String find() {
        return "task_list";
    }
    @RequestMapping("/list")
    @ResponseBody
    public Map list(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        int total = taskService.getTotalCount();
        List<Task> tasks = taskService.selectListByPageAndRows(page, rows);
        map.put("total", total);
        map.put("rows", tasks);
        return map;
    }
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Task get(@PathVariable String id){
        return taskService.findById(id);
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Task> get_data(){
        return taskService.selectAll();
    }


    /**
     * 增加
     * @return
     */
    @RequestMapping(value = {"add_judge","add"})
    public String add_judge() {
        return "task_add";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(Task task) {
        Map<String, Object> map = new HashMap<>();
        boolean ok = taskService.insert(task);
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
        return "task_list";
    }
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map delete_batch(String[] ids){
        Map<String, Object> map = new HashMap<>();
        for (String id : ids) {
            boolean ok = taskService.delete(id);
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
        return "task_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update_all(Task task){
        Map<String, Object> map = new HashMap<>();
        boolean update = taskService.update(task);
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
    @RequestMapping("search_task_by_taskId")
    @ResponseBody
    public Map search_task_by_taskId(Integer page, Integer rows, String searchValue){
        Map<String, Object> map = new HashMap<>();
        int total = taskService.getCountById(searchValue);
        List<Task> tasks = taskService.selectListById(page, rows, searchValue);
        map.put("total", total);
        map.put("rows", tasks);
        return map;
    }

    @RequestMapping("search_task_by_taskWorkId")
    @ResponseBody
    public Map search_task_by_taskWorkId(Integer page, Integer rows, String searchValue){
        Map<String, Object> map = new HashMap<>();
        int total = taskService.getCountByWorkId(searchValue);
        List<Task> tasks = taskService.selectListByWorkId(page, rows, searchValue);
        map.put("total", total);
        map.put("rows", tasks);
        return map;
    }

    @RequestMapping("search_task_by_taskManufactureSn")
    @ResponseBody
    public Map search_task_by_taskManufactureSn(Integer page, Integer rows, String searchValue){
        Map<String, Object> map = new HashMap<>();
        int total = taskService.getCountByManufactureSn(searchValue);
        List<Task> tasks = taskService.selectListByManufactureSn(page, rows, searchValue);
        map.put("total", total);
        map.put("rows", tasks);
        return map;
    }
}
