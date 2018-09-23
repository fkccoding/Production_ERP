package com.erp.controller.a;

import com.erp.bean.Manufacture;
import com.erp.service.a.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manufacture")
public class ManufactureController {
    @Autowired
    ManufactureService manufactureService;

    @RequestMapping("/find")
    public String find() {
        return "manufacture_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map list(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();

        int total = manufactureService.getTotalCount();
        List<Manufacture> manufactures = manufactureService.selectListByPageAndRows(page, rows);
        System.out.println("manufactures="+manufactures);
        map.put("total", total);
        map.put("rows", manufactures);
        return map;
    }
}
