package com.erp.controller.e;

import com.erp.bean.UnqualifyApply;
import com.erp.service.e.UnqualifyApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:YueZhenLi
 * @Date:Created in 2018/8/30
 */

@Controller
@RequestMapping("/unqualify")
public class UnqualifyApplyController {

    @Autowired
    UnqualifyApplyService unqualifyApplyService;

    @RequestMapping("/add_judge")
    @ResponseBody
    public Map add_judge(){
        return new HashMap();
    }

    @RequestMapping("/add")
    public String add(){
        return "unqualify_add";
    }

    @RequestMapping("/insert")
    public Map insert(UnqualifyApply unqualifyApply){

        HashMap<Object, Object> hashMap = new HashMap<>();
        Integer insert = unqualifyApplyService.insert(unqualifyApply);
        if (insert==1){
            hashMap.put("status", "200");
            hashMap.put("msg", "OK");
            hashMap.put("data", null);
        }
        return hashMap;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public Map delete_judge(){
        return new HashMap();
    }
//    @RequestMapping("/delete_judge")
//    public String delete_judge(){
//        return "forward:/delete_batch";
//    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map delete_batch(String[] ids){
        unqualifyApplyService.delete_batch(ids);
        HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.put("status", "200");
            hashMap.put("msg", "OK");
            hashMap.put("data", null);
        return hashMap;
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public Map edit_judge(){
        return new HashMap();
    }

    @RequestMapping("/edit")
    public String edit(){
        return "unqualify_edit";
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public Map update_all(UnqualifyApply unqualifyApply){
        Integer update = unqualifyApplyService.update_all(unqualifyApply);
        HashMap<Object, Object> hashMap = new HashMap<>();
        if (update==1){
            hashMap.put("status", "200");
            hashMap.put("msg", "OK");
            hashMap.put("data", null);
        }
        return hashMap;
    }

    @RequestMapping("/find")
    public String returnToList(){
        return "unqualify_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map selectPartUnqualifyApplys(Integer page, Integer rows){

        List<UnqualifyApply> unqualifyList = unqualifyApplyService.selectPartUnqualifyApplys(page, rows);
        Integer total = unqualifyList.size();
        HashMap<Object, Object> hashMap = new HashMap<>();

        hashMap.put("total", total);
        hashMap.put("rows", unqualifyList);

        return hashMap;
    }

    @RequestMapping("/search_unqualify_by_unqualifyId")
    @ResponseBody
    public Map search_unqualify_by_unqualifyId(String searchValue, Integer page, Integer rows){

        List<UnqualifyApply> unqualifyApplies = unqualifyApplyService.search_unqualify_by_unqualifyId(searchValue, page, rows);
        Integer total = unqualifyApplies.size();
        HashMap<Object, Object> hashMap = new HashMap<>();


        hashMap.put("total", total);
        hashMap.put("rows", unqualifyApplies);

        return hashMap;
    }


    @RequestMapping("/search_unqualify_by_productName")
    @ResponseBody
    public Map search_unqualify_by_productName(String searchValue, Integer page, Integer rows){

        List<UnqualifyApply> unqualifyApplies = unqualifyApplyService.search_unqualify_by_productName(searchValue, page, rows);
        Integer total = unqualifyApplies.size();
        HashMap<Object, Object> hashMap = new HashMap<>();

        hashMap.put("total", total);
        hashMap.put("rows", unqualifyApplies);

        return hashMap;
    }
}
