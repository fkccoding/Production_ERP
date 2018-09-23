package com.erp.controller.c;

import com.erp.bean.TechnologyPlan;
import com.erp.bean.device.TechnologyPlanVo;
import com.erp.service.c.TechnologyPlanService;
import com.erp.service.c.TechnologyServiceInterface;
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
@RequestMapping("/technologyPlan")
public class TechnologyPlanController{

    @Autowired
    @Qualifier("/planService")
    private TechnologyPlanService planService;
    @Autowired
    @Qualifier("technologyService")
    private TechnologyServiceInterface technologyServiceInterface;

    @RequestMapping("/get_data")
    @ResponseBody
    public List<TechnologyPlanVo> getData(){
        return planService.findAlltechnology();
    }

    @RequestMapping("/find")
    public String find(){
        return "/technologyPlan_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map findAll(Integer page,Integer rows){

        Page page1=PageHelper.startPage(page,rows);
        List<TechnologyPlanVo> list=planService.findAll(new TechnologyPlan());

        Map<String,Object> map=new HashMap<>();

        PageInfo<TechnologyPlanVo> pageInfo=new PageInfo<>(list);
        map.put("total",pageInfo.getTotal());
        map.put("rows",list);
        return map;
    }
    @RequestMapping("/search_technologyPlan_by_technologyPlanId")
    @ResponseBody
    public Map searchById(Integer page,Integer rows,String searchValue){
        TechnologyPlan technologyPlan=new TechnologyPlan();
        technologyPlan.setTechnologyPlanId(searchValue);
        Page page1=PageHelper.startPage(page,rows);

        List<TechnologyPlanVo> list = planService.findAll(technologyPlan);

        Map<String,Object> map=new HashMap<>();
        PageInfo<TechnologyPlanVo> pageInfo=new PageInfo<>(list);
        map.put("total",pageInfo.getTotal());
        map.put("rows",list);
        return map;
    }
    @RequestMapping("/search_technologyPlan_by_technologyName")
    @ResponseBody
    public Map searchByName(Integer page,Integer rows,String searchValue){

        Page page1=PageHelper.startPage(page,rows);
        List<TechnologyPlanVo> list = planService.findByName(searchValue);
        System.out.println(list);
        Map<String,Object> map=new HashMap<>();

        PageInfo<TechnologyPlanVo> pageInfo=new PageInfo<>(list);

        map.put("total",pageInfo.getTotal());
        map.put("rows",list);
        return map;
    }

    @RequestMapping("/add_judge")
    public String add_judge(){
        return "/technologyPlan_list";
    }
    @RequestMapping("/add")
    public String add(){

        return "/technologyPlan_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(TechnologyPlan technologyPlan){
        Map<String,Object> map=new HashMap<>();
        boolean b=planService.insert(technologyPlan);
        if (b){
            map.put("status",200);
        }
        return map;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return "/technologyPlan_list";
    }
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map delete_judge(String[] ids){

        Map<String,Object> map=new HashMap<>();
        boolean b=planService.delete(ids);
        if (b){
            map.put("status",200);
        }
        return map;
    }

    @RequestMapping("/edit_judge")
    public String edit_judge(){
        return "/technologyPlan_list";
    }
    @RequestMapping("/edit")
    public String edit(){
        return "/technologyPlan_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update_all(TechnologyPlan technologyPlan, Integer page, Integer rows){
        Map<String,Object> map=new HashMap<>();
        boolean flag=planService.updateAll(technologyPlan);
        if (flag){
            map.put("status",200);
        }
        return map;
    }

}
