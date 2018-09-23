package com.erp.controller.c;

import com.erp.bean.Technology;
import com.erp.bean.TechnologyRequirement;
import com.erp.bean.device.TechnologyRequirementVo;
import com.erp.service.c.TechnologyRequirementInterface;
import com.erp.service.c.TechnologyServiceInterface;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/technologyRequirement")
public class TechnologyRequirementController {

    @Autowired
    @Qualifier("requirementService")
    private TechnologyRequirementInterface requirementService;
    @Autowired
    @Qualifier("technologyService")
    private TechnologyServiceInterface technologyService;

    @RequestMapping("/find")
    public String find(){
        return "technologyRequirement_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map findAll(Integer page,Integer rows){
        Page page1=PageHelper.startPage(page,rows);
        List<TechnologyRequirementVo> list=requirementService.findAll();

        Map<String,Object> map=new HashMap<>();

        PageInfo<TechnologyRequirementVo> pageInfo=new PageInfo<>(list);
        map.put("total",pageInfo.getTotal());
        map.put("rows",list);
        return map;
    }

    @RequestMapping("/search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public Map selectTechnologyRequirementById(Integer page,Integer rows,String searchValue){
        Page page1=PageHelper.startPage(page,rows);
        TechnologyRequirementVo technologyRequirementVo = requirementService.selectTechnologyRequirementById(searchValue);
        Map<String,Object> map=new HashMap<>();

        List<TechnologyRequirementVo> arrayList=new ArrayList<>();

        arrayList.add(technologyRequirementVo);

        PageInfo<TechnologyRequirementVo> pageInfo=new PageInfo<>(arrayList,page);
        map.put("total",pageInfo.getTotal());
        map.put("rows",arrayList);
        return map;
    }
    @RequestMapping("/search_technologyRequirement_by_technologyName")
    @ResponseBody
    public Map selectTechnologyRequirementByName(Integer page,Integer rows,String searchValue){
        Page page1=PageHelper.startPage(page,rows);

        List<TechnologyRequirementVo> list= requirementService.selectTechnologyRequirementByName(searchValue);
        Map<String,Object> map=new HashMap<>();

        PageInfo<TechnologyRequirementVo> pageInfo=new PageInfo<>(list,page);
        map.put("total",pageInfo.getTotal());
        map.put("rows",list);
        return map;
    }

    @RequestMapping("/add_judge")
    public String add_judge(){
        return "/technologyRequirement_list";
    }
    @RequestMapping("/add")
    public String add(){

        return "/technologyRequirement_add";
    }
    @RequestMapping("/get_data")
    @ResponseBody
    public List<Technology> get_data(){

        List<Technology> list=technologyService.findTechnology();
        return list;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(TechnologyRequirement requirement){
        Map<String,Object> map=new HashMap<>();

        boolean b=requirementService.insert(requirement);
        if (b){
            map.put("status",200);
        }
        return map;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return "/technologyRequirement_list";
    }
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map delete_judge(String[] ids){

        Map<String,Object> map=new HashMap<>();
        boolean b=requirementService.delete(ids);
        if (b){
            map.put("status",200);
        }
        return map;
    }

    @RequestMapping("/edit_judge")
    public String edit_judge(){
        return "/technologyRequirement_list";
    }
    @RequestMapping("/edit")
    public String edit(){
        return "/technologyRequirement_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update_all(TechnologyRequirement requirement,Integer page,Integer rows){
        Map<String,Object> map=new HashMap<>();
        boolean flag=requirementService.updateAll(requirement);

        if (flag){
            map.put("status",200);
        }
        return map;
    }

}
