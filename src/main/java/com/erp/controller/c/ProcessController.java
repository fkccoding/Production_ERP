package com.erp.controller.c;

import com.erp.bean.Process;
import com.erp.service.c.ProcessService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/process")
public class ProcessController {
    @Autowired
    @Qualifier("/processService")
    private ProcessService processService;

    @RequestMapping("/find")
    public String find(){
        return "/process_list";
    }
    @RequestMapping("/list")
    @ResponseBody
    public Map list(Integer page,Integer rows){
        Page page1=PageHelper.startPage(page,rows);
        List<Process> list=processService.findAll(new Process());

        Map<String,Object> map=new HashMap<>();

        PageInfo<Process> pageInfo=new PageInfo<>(list);
        map.put("total",pageInfo.getTotal());
        map.put("rows",list);
        return map;
    }

    @ResponseBody
    @RequestMapping("/get_data")
    public List<Process> getData(){
        List<Process> list=processService.findAll(new Process());
        return list;
    }

    @RequestMapping("/search_process_by_processId")
    @ResponseBody
    public Map searchById(String searchValue){
        Process process=new Process();
        process.setProcessId(searchValue);

        List<Process> list = processService.findAll(process);
        Map<String,Object> map=new HashMap<>();
        PageInfo<Process> pageInfo=new PageInfo<>(list);
        map.put("total",pageInfo.getTotal());
        map.put("rows",list);
        return map;
    }
    @RequestMapping("/search_process_by_technologyPlanId")
    @ResponseBody
    public Map searchByPlanId(String searchValue){
        Process process=new Process();
        process.setTechnologyPlanId(searchValue);

        List<Process> list = processService.findAll(process);
        System.out.println(list);
        Map<String,Object> map=new HashMap<>();

        PageInfo<Process> pageInfo=new PageInfo<>(list);

        map.put("total",pageInfo.getTotal());
        map.put("rows",list);
        return map;
    }
    @RequestMapping("/add_judge")
    public String add_judge(){
        return "/process_list";
    }
    @RequestMapping("/add")
    public String add(){

        return "/process_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(Process process){
        Map<String,Object> map=new HashMap<>();
        boolean b=processService.insertProcess(process);

        if (b){
            map.put("status",200);
        }
        return map;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return "/process_list";
    }
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map delete_judge(String[] ids){

        Map<String,Object> map=new HashMap<>();
        boolean b=processService.delete(ids);
        if (b){
            map.put("status",200);
        }
        return map;
    }

    @RequestMapping("/edit_judge")
    public String edit_judge(){
        return "/process_list";
    }
    @RequestMapping("/edit")
    public String edit(){
        return "/process_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update_all(Process process, Integer page, Integer rows){
        Map<String,Object> map=new HashMap<>();
        boolean flag=processService.updateAll(process);
        if (flag){
            map.put("status",200);
        }
        return map;
    }


}
