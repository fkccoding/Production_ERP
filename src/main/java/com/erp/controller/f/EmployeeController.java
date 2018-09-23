package com.erp.controller.f;

import com.erp.bean.Department;
import com.erp.bean.Employee;
import com.erp.service.f.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/find")
    public String find() {
        return "employee_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map list(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();

        int total = employeeService.getTotalCount();
        List<Employee> employees = employeeService.selectListByPageAndRows(page, rows);
        map.put("total", total);
        map.put("rows", employees);
        return map;
    }
    @RequestMapping("/get/{empid}")
    @ResponseBody
    public Employee getItemById(@PathVariable String empid){
          Employee employee = employeeService.get(empid);
          return employee;
    }


   /* @RequestMapping("search_employee_by_employeeId")
    @ResponseBody
    public Employee getItemById(String searchValue, Integer page, Integer rows){
        Employee employee = employeeService.get(empid);
        return employee;
    }*/
   @RequestMapping("/add_judge")
   public String add_judge(){
       return "employee_add";
   }
    @RequestMapping("/add")
    public String add(){
        return "employee_add";
    }
   @RequestMapping("/insert")
   @ResponseBody
   public Map insert(Employee employee){
       Map<String , Object> map = new HashMap<>();

       int insert = employeeService.insert(employee);
       if (insert == 1) {
           map.put("status",200);
           map.put("msg","ok");
       }
       else{
           map.put("status",500);
           map.put("msg","fail");
       }
       return map;
   }
   @RequestMapping("/delete_judge")
   public String delete_judge(){
       return "employee_list";
   }
   @RequestMapping("/delete_batch")
   @ResponseBody
   public Map delete(String[] ids){
       HashMap<String, Object> map = new HashMap<>();
       for (String id : ids) {
           int delete = employeeService.delete(id);
           if (delete == 1) {
             map.put("status",200);
             map.put("msg","ok");
           }
           else {
               map.put("status",500);
               map.put("msg","fail");
           }

       }

       return map;
   }
   @RequestMapping("/edit_judge")
   public String edit_judge(){
       return "employee_edit";
   }
   @RequestMapping("edit")
   public String edit(){
       return "employee_edit";
   }
   @RequestMapping("/update_all")
   @ResponseBody
   public Map update_all(Employee employee){
       Map<String, Object> map = new HashMap<>();
      int update = employeeService.update(employee);
       if (update == 1) {
           map.put("status",200);
           map.put("msg","ok");
       }else{
           map.put("status",500);
           map.put("msg","fail");
       }
       return map;
   }

}
