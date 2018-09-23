package com.erp.controller.c;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import com.erp.bean.Technology;
import com.erp.service.c.TechnologyServiceInterface;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    @Qualifier("technologyService")
    private TechnologyServiceInterface technologyService;

    @RequestMapping("/find")
    public String findTechnology(){
        return "technology_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map findTechnologys(Integer page,Integer rows){
        Map<String,Object> map=new HashMap<>();
        Page page1=PageHelper.startPage(page,rows);
        //获取工艺列表
        List<Technology> list=technologyService.findTechnology();

        PageInfo<Technology> pageInfo=new PageInfo<>(list);
        map.put("total",pageInfo.getTotal());
        map.put("rows",list);
        return map;
    }

    /**
     *
     * @param searchValue
     * @return
     */
    @RequestMapping("/search_technology_by_technologyId")
    @ResponseBody
    public Map selectTechnologyById(String searchValue){
        //根据id获取工艺对象
        Technology technology=technologyService.selectTechnologyById(searchValue);
        //添加到list
        System.out.println(searchValue);
        List<Technology> list=new ArrayList<>();
        list.add(technology);
        //添加到map
        Integer total=list.size();
        Map<String,Object> map=new HashMap<>();
        map.put("total",total);
        map.put("rows",list);

        return map;
    }

    /**
     *
     * @param searchValue
     * @return
     */
    @RequestMapping("/search_technology_by_technologyName")
    @ResponseBody
    public Map selectTechnologyByName(String searchValue){
        List<Technology> list=technologyService.selectTechnologyByName(searchValue);
        Map<String,Object> map=new HashMap<>();

        Integer total=list.size();
        map.put("total",total);
        map.put("rows",list);
        return map;
    }

    @RequestMapping(value = {"/add","/add_judge"})
    public String addJudge(){
        return "technology_add";
    }

    /**
     * 添加工艺
     * @param technology  参数是工艺对象
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Map add(Technology technology){
        Map<String,Object> map=new HashMap<>();

        technologyService.insertTechnology(technology);
        map.put("status",200);
        return map;
    }

    @RequestMapping("/delete_judge")
    public String delete(){

        return "technology_list";
    }
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map delete_batch(String[] ids){
        boolean b=false;
        for (String id:ids){
            b = technologyService.deleteTechnologyById(id);
        }
        Map<String, Object> map = new HashMap<>();
        if (b) {
            map.put("status",200);
        }
        return map;
    }

    @RequestMapping("/edit_judge")
    public String edit_judge(){
        return "/technology_list";
    }
    @RequestMapping("/edit")
    public String edit(){
        return "/technology_edit";
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public Map editTechnology(Technology technology){
        technologyService.updateAll(technology);
        Map<String,Object> map=new HashMap<>();
        map.put("status",200);
        return map;
    }
    @RequestMapping("/get_data")
    @ResponseBody
    public List<Technology> getDate(){
        return technologyService.findTechnology();
    }
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Technology getTechnologyById(@PathVariable String id){
        System.out.println(id);
        Technology technology=technologyService.selectTechnologyById(id);
        return technology;
    }

}
