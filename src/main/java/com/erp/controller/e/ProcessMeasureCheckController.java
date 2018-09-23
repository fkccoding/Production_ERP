package com.erp.controller.e;

import com.erp.bean.ProcessMeasureCheck;
import com.erp.service.e.ProcessMeasureCheckService;
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
@RequestMapping("/p_measure_check")
public class ProcessMeasureCheckController {

    @Autowired
    ProcessMeasureCheckService processMeasureCheckService;

    @RequestMapping("/find")
    public String returnToList(){

        return "p_measure_check_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map selectPartProcessMeasureChecks(Integer page, Integer rows){

        List<ProcessMeasureCheck> processMeasureChecks =
                        processMeasureCheckService.selectPartProcessMeasureChecks(page, rows);
        Integer total = processMeasureChecks.size();
        HashMap<Object, Object> hashMap = new HashMap<>();

        hashMap.put("total", total);
        hashMap.put("rows", processMeasureChecks);

        return hashMap;
    }

     @RequestMapping("/search_pMeasureCheck_by_pMeasureCheckId")
    @ResponseBody
    public Map search_pMeasureCheck_by_pMeasureCheckId(String searchValue, Integer page, Integer rows){

        List<ProcessMeasureCheck> processMeasureChecks =
                        processMeasureCheckService.search_pMeasureCheck_by_pMeasureCheckId(searchValue, page, rows);
        Integer total = processMeasureChecks.size();
        HashMap<Object, Object> hashMap = new HashMap<>();

        hashMap.put("total", total);
        hashMap.put("rows", processMeasureChecks);

        return hashMap;
    }

}
