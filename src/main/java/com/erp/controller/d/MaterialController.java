package com.erp.controller.d;


import com.erp.bean.Material;
import com.erp.service.d.MaterialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MaterialController {

    @Autowired
    MaterialService materialService;

    //首先是响应前端返回到materialList.jsp的页面  然后就是从list.jsp获取到另外的url请求
    @RequestMapping("/material/find")
    public ModelAndView productList() {
        ModelAndView modelAndView = new ModelAndView();
        //在最后的检验url的时候可以根据 视图解析器 去做改变
        modelAndView.setViewName("material_list");
        return modelAndView;
    }


    /**
     * //此函数不必和前端的Jquery的调用函数名相同
     * // 此时只需要返回map就行 则会生成Json的数据 可以不用指定具体返回到的页面
     * 因为谁请求的返回的数据就是给谁  当需要转发到另外一个页面时 则是需要转发到那个页面的jsp 同时注意视图解析器
     */
    @ResponseBody //表示返回Json类型
    @RequestMapping("/material/list")
    public Map datagrid132(String page, String rows) {

        Map<String, Object> map = new HashMap<>();

        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(rows);

        PageHelper.startPage(pageNum, pageSize);

        //利用materialService获取到物料的list集合
        List<Material> sysPermissionList = materialService.selectMeterials();

        //对查询的数据进行分页
        PageInfo<Material> materialPageInfo = new PageInfo<>(sysPermissionList, pageNum);
        long total = materialPageInfo.getTotal();

        map.put("rows", sysPermissionList);
        map.put("total", total);

        return map;
    }


    //弹出小窗 弹窗时 是两次请求
    @RequestMapping("/material/{add_judge,add}")
    public String appearAdd() {

        return "material_add";
    }


    @ResponseBody
    @RequestMapping("/material/insert")
    public Map addMaterial(Material material) {

        materialService.insertMaterial(material);

        Map<String, Object> map = new HashMap<>();
        //返回的是各种状态信息的Json数据
        map.put("status", 200);
        map.put("msg", "OK");

        return map;

    }

    //返回物料信息修改的小窗口
    @RequestMapping("/material/edit_judge")
    public String appearEdit(Material material) {
        //返回到编辑的小窗口
        return "material_edit";
    }

    @RequestMapping("/material/edit")
    public String appearEdit2(Material material) {
        //返回到编辑的小窗口
        return "material_edit";
    }

    //此时根据物料信息的Id修改物料信息
    @ResponseBody
    @RequestMapping("/material/update_all")
    public Map updateMaterial(Material material) {

        materialService.updateMaterial(material);

        Map<String, Object> map = new HashMap<>();
        //返回的是各种状态信息的Json数据
        map.put("status", 200);
        map.put("msg", "OK");

        return map;

    }

    //按条件查询物料的信息
    @ResponseBody
    @RequestMapping("/material/search_material_by_materialId")
    public Map searchByCodition(String searchValue, String page,String rows){

        Map<String, Object> map = new HashMap<>();

        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(rows);

        //开始分页  内部通过修改sql语句
        PageHelper.startPage(pageNum, pageSize);

        //利用materialService获取到物料的list集合
        List<Material> sysPermissionList = materialService.selectMeterialsByMaterialId(searchValue);

        //对查询的数据进行分页
        PageInfo<Material> materialPageInfo = new PageInfo<>(sysPermissionList, pageNum);
        long total = materialPageInfo.getTotal();

        map.put("rows", sysPermissionList);
        map.put("total", total);

        return map;

    }

    //按条件查询物料
    @ResponseBody
    @RequestMapping("/material/search_material_by_materialType")
    public Map searchBymaterialType(String searchValue,String page,String rows){

        Map<String, Object> map = new HashMap<>();

        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(rows);

        //开始分页  内部通过修改sql语句
        PageHelper.startPage(pageNum, pageSize);

       List<Material> sysPermissionList = materialService.selectMeterialsBymaterialType(searchValue);

       //对查询的数据进行分页
        PageInfo<Material> materialPageInfo = new PageInfo<>(sysPermissionList, pageNum);
        long total = materialPageInfo.getTotal();

        map.put("rows", sysPermissionList);
        map.put("total", total);

        return map;
    }

    /**  删除一部分的Material
     */
    @ResponseBody
    @RequestMapping("/material/delete_judge")
    public Map deleteJudge(){

        Map<String, Object> map = new HashMap<>();

        return map;
    }

    @ResponseBody
    @RequestMapping("/material/delete_batch")
    public Map deleteBatch(String[] ids){

      /*  System.out.println("删除的 信息 "+ ids);*/

       materialService.deleteBench(ids);

        Map<String, Object> map = new HashMap<>();
        //返回的是各种状态信息的Json数据
        map.put("status", 200);
        map.put("msg", "OK");

        return map;
    }

    //修改备注
    @ResponseBody
    @RequestMapping("/material/update_note")
    public Map updateNote(String materialId,String note){

        materialService.updateMaterialNote(materialId,note);

        Map<String, Object> map = new HashMap<>();
        //返回的是各种状态信息的Json数据
        map.put("status", 200);
        map.put("msg", "OK");

        return map;
    }


}
