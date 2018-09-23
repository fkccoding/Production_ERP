package com.erp.controller.a;

import com.erp.bean.Product;
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
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    /**
     * 显示
     * @return
     */
    @RequestMapping("/find")
    public String find() {
        return "product_list";
    }
    @RequestMapping("/list")
    @ResponseBody
    public Map list(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        int total = productService.getTotalCount();
        List<Product> products = productService.selectListByPageAndRows(page, rows);
        map.put("total", total);
        map.put("rows", products);
        return map;
    }
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Product get(@PathVariable String id){
        return productService.findById(id);
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List get_data(){
        return productService.selectAll();
    }


    /**
     * 增加
     * @return
     */
    @RequestMapping(value = {"add_judge","add"})
    public String add_judge() {
        return "product_add";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(Product product) {
        Map<String, Object> map = new HashMap<>();
        boolean ok = productService.insert(product);
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
        return "product_list";
    }
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map delete_batch(String[] ids){
        Map<String, Object> map = new HashMap<>();
        for (String id : ids) {
            boolean ok = productService.delete(id);
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
    public String edit_judge(){
        return "product_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update_all(Product product){
        Map<String, Object> map = new HashMap<>();
        System.out.println("product="+product);
        boolean update = productService.update(product);
        if (update) {
            map.put("status",200);
        } else {
            map.put("msg", "修改失败！");
        }
        return map;
    }

    /**
     *查询
     */
    @RequestMapping("search_product_by_productId")
    @ResponseBody
    public Map search_product_by_productId(Integer page, Integer rows, String searchValue){
        Map<String, Object> map = new HashMap<>();
        int total = productService.getCountById(searchValue);
        List<Product> products = productService.selectListById(page, rows, searchValue);
        map.put("total", total);
        map.put("rows", products);
        return map;
    }

    @RequestMapping("search_product_by_productName")
    @ResponseBody
    public Map search_product_by_productName(Integer page, Integer rows,String searchValue){
        Map<String, Object> map = new HashMap<>();
        int total = productService.getCountByName(searchValue);
        List<Product> products = productService.selectListByName(page, rows, searchValue);
        map.put("total", total);
        map.put("rows", products);
        return map;
    }

    @RequestMapping("search_product_by_productType")
    @ResponseBody
    public Map search_product_by_productType(Integer page, Integer rows,String searchValue){
        Map<String, Object> map = new HashMap<>();
        int total = productService.getCountByType(searchValue);
        List<Product> products = productService.selectListByType(page, rows, searchValue);
        map.put("total", total);
        map.put("rows", products);
        return map;
    }

    @RequestMapping("/findByName")
    public List<Product> findByName(String name){
        return productService.findByName(name);
    }
}
