package com.erp.controller.a;

import com.erp.bean.COrder;
import com.erp.service.a.COrderService;
import com.erp.service.a.CustomService;
import com.erp.service.a.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class COrderController {

    @Autowired
    COrderService cOrderService;
    @Autowired
    CustomService customService;
    @Autowired
    ProductService productService;

    /**
     * 显示
     * @return
     */
    @RequestMapping("/find")
    public String find() {
        return "order_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map list(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        int total = cOrderService.getTotalCount();
        List<COrder> cOrders = cOrderService.selectListByPageAndRows(page, rows);
        map.put("total", total);
        map.put("rows", cOrders);
        return map;
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public COrder get(@PathVariable String id){
        return cOrderService.findById(id);
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<COrder> get_data(){
        return cOrderService.selectAll();
    }

    /**
     * 增加
     * @return
     */
    @RequestMapping(value = {"add_judge","add"})
    public String add_judge() {
        return "order_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(COrder cOrder) {
        Map<String, Object> map = new HashMap<>();
        boolean ok = cOrderService.insert(cOrder);
        if (ok) {
            map.put("status", 200);
        } else {
            map.put("msg", "添加失败！");
        }
        return map;
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("/delete_judge")
    public String delete_judge(){
        return "order_list";
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map delete_batch(String[] ids){
        Map<String, Object> map = new HashMap<>();
        for (String id : ids) {
            boolean ok = cOrderService.delete(id);
            if (ok) {
                map.put("status", 200);
                map.put("msg","删除成功！");
            } else {
                map.put("msg", "删除失败！");
            }
        }
        return map;
    }


    /**
     * 编辑
     * @return
     */
    @RequestMapping(value = {"edit_judge", "edit"})
    public String edit_judge() {
        return "order_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update_all(COrder cOrder){
        Map<String, Object> map = new HashMap<>();
        boolean ok = cOrderService.updateAll(cOrder);
        if (ok) {
            map.put("status", 200);
            map.put("msg","修改成功！");
        } else {
            map.put("msg", "修改失败！");
        }
        return map;
    }


    @RequestMapping("/update_note")
    @ResponseBody
    public Map update_note(String note) {
        Map<String, Object> map = new HashMap<>();

        COrder cOrder = new COrder();
        cOrder.setNote(note);
        boolean ok = cOrderService.updateNote(cOrder);
        if (ok) {
            map.put("status", 200);
        } else {
            map.put("msg", "修改失败！");
        }
        return map;
    }


    /**
     * 查找
     */
    @RequestMapping("search_order_by_orderId")
    @ResponseBody
    public Map search_order_by_orderId(Integer page, Integer rows, String searchValue){
        Map<String, Object> map = new HashMap<>();
        int total = cOrderService.getCountById(searchValue);
        List<COrder> cOrders = cOrderService.selectListById(page, rows, searchValue);
        map.put("total", total);
        map.put("rows", cOrders);
        return map;
    }

    @RequestMapping("search_order_by_orderCustom")
    @ResponseBody
    public Map search_order_by_orderCustom(Integer page, Integer rows, String searchValue){
        Map<String, Object> map = new HashMap<>();
        String customId = customService.findIdByName(searchValue);
        int total = cOrderService.getCountByCustomId(customId);
        List<COrder> cOrders = cOrderService.selectListByCustomId(page, rows, customId);
        map.put("total", total);
        map.put("rows", cOrders);
        return map;
    }

    @RequestMapping("search_order_by_orderProduct")
    @ResponseBody
    public Map search_order_by_orderProduct(Integer page, Integer rows, String searchValue){
        Map<String, Object> map = new HashMap<>();
        String productId = productService.findIdByName(searchValue);
        int total = cOrderService.getCountByProductId(productId);
        List<COrder> cOrders = cOrderService.selectListByProductId(page, rows, productId);
        map.put("total", total);
        map.put("rows", cOrders);
        return map;
    }
}
