package com.erp.controller.f;

import com.erp.bean.Department;
import com.erp.service.f.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/find")
    public String find() {
        return "department_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map list(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();

        int total = departmentService.getTotalCount();
        List<Department> departments = departmentService.selectListByPageAndRows(page, rows);
        map.put("total", total);
        map.put("rows", departments);
        return map;
    }
    @RequestMapping("/get_data")
    @ResponseBody
    public List<Department> getData(){
          return departmentService.find();
    }
    @RequestMapping("/get/{depid}")
    @ResponseBody
    public Department getDepartmentById(@PathVariable String departmentId){
        return departmentService.getDepartmentById(departmentId);
    }
}
