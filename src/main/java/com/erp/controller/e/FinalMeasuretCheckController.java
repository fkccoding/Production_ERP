package com.erp.controller.e;

import com.erp.bean.FinalMeasuretCheck;
import com.erp.bean.UnqualifyApply;
import com.erp.service.e.FinalMeasuretCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:YueZhenLi
 * @Date:Created in 2018/8/31
 */

@Controller
@RequestMapping
public class FinalMeasuretCheckController {

    @Autowired
    FinalMeasuretCheckService finalMeasuretCheckService;

    @RequestMapping("/measure/find")
    public String returnToList(){
        return "measurement_list";
    }

    @RequestMapping("/measure/list")
    @ResponseBody
    public Map selectPartFinalMeasuretChecks(Integer page, Integer rows){

        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckService.selectPartFinalMeasuretChecks(page, rows);
        Integer total = finalMeasuretChecks.size();
        HashMap<Object, Object> hashMap = new HashMap<>();

        hashMap.put("total", total);
        hashMap.put("rows", finalMeasuretChecks);

        return hashMap;
    }

    @RequestMapping("/measure/search_fMeasureCheck_by_fMeasureCheckId")
    @ResponseBody
    public Map search_fMeasureCheck_by_fMeasureCheckId(String searchValue, Integer page, Integer rows){
        HashMap<Object, Object> hashMap = new HashMap<>();
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckService.search_fMeasureCheck_by_fMeasureCheckId(searchValue, page, rows);
        Integer total = finalMeasuretChecks.size();
        hashMap.put("total", total);
        hashMap.put("rows", finalMeasuretChecks);
        return hashMap;
    }

    @RequestMapping("/measure/search_fMeasureCheck_by_orderId")
    @ResponseBody
    public Map search_fMeasureCheck_by_orderId(String searchValue, Integer page, Integer rows){
        HashMap<Object, Object> hashMap = new HashMap<>();
        List<FinalMeasuretCheck> finalMeasuretChecks =
                    finalMeasuretCheckService.search_fMeasureCheck_by_orderId(searchValue, page, rows);
        Integer total = finalMeasuretChecks.size();
        hashMap.put("total", total);
        hashMap.put("rows", finalMeasuretChecks);
        return hashMap;
    }

    @RequestMapping("/fMeasureCheck/add_judge")
    @ResponseBody
    public Map add_judge(){
        return new HashMap();
    }

    @RequestMapping("/measure/add")
    public String add(){
        return "measurement_add";
    }

    @RequestMapping("/measure/inser")
    public Map insert(FinalMeasuretCheck finalMeasuretCheck){

        HashMap<Object, Object> hashMap = new HashMap<>();
        Integer insert = finalMeasuretCheckService.insert(finalMeasuretCheck);
        if (insert==1){
            hashMap.put("status", "200");
            hashMap.put("msg", "OK");
            hashMap.put("data", null);
        }
        return hashMap;
    }


    @RequestMapping("/fMeasureCheck/delete_judge")
    @ResponseBody
    public Map delete_judge(){
        return new HashMap();
    }


    @RequestMapping("/measure/delete_batch")
    @ResponseBody
    public Map delete_batch(String[] ids){
        finalMeasuretCheckService.delete_batch(ids);
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("status", "200");
        hashMap.put("msg", "OK");
        hashMap.put("data", null);
        return hashMap;
    }




}
