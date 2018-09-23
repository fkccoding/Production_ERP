package com.erp.controller.d;

import com.erp.bean.Material;
import com.erp.bean.MaterialReceive;
import com.erp.service.d.MaterialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MaterialRecieverController {

    @Autowired
    MaterialService materialService;

    @RequestMapping("/materialReceive/find")
    public String materialRecive() {
        return "materialReceive_list";
    }

    @ResponseBody
    @RequestMapping("/materialReceive/list")
    public Map materialReceiveList(String page, String rows) {

        Map<String, Object> map = new HashMap<>();

        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(rows);

        PageHelper.startPage(pageNum, pageSize);

        List<MaterialReceive> sysPermissionList = materialService.selectListMaterialRecive();

        //通过此处将list里的每个集合获取到里面对象引用
        for (MaterialReceive materialReceive : sysPermissionList) {
            Material material = materialService.selectSingleMaterial(materialReceive.getMaterialId());
            materialReceive.setMaterial(material);
        }

        //利用分页的数据分析 有多少行
        PageInfo<MaterialReceive> materialPageInfo = new PageInfo<>(sysPermissionList, pageNum);

        long total = materialPageInfo.getTotal();

        map.put("rows", sysPermissionList);
        map.put("total", total);

        return map;
    }


    //显示增加MaterialReceiver的小窗口
    @RequestMapping("/materialReceive/add_judge")
    public String materialReceiveAddJudge() {
        return "materialReceive_add";
    }

    @RequestMapping("/materialReceive/add")
    public String materialReceiveAdd() {
        return "materialReceive_add";
    }

    /**
     * 获取到下拉选框的值
     */
    @ResponseBody
    @RequestMapping("/material/get_data")
    public List getMaterialID() {

        List<Material> materialList = materialService.selectMeterials();

        return materialList;
    }

    /**
     * 在添加MaterialReceiver的时注意将相应的数量增加
     */
    @ResponseBody
    @RequestMapping("/materialReceive/insert")
    public Map insertMaterialReceive(MaterialReceive materialReceive) {
        Map<Object, Object> map = new HashMap();
        materialService.addMaterialReceiver(materialReceive);

        map.put("status", 200);
        map.put("msg", "OK");

        return map;
    }

    //查看物料
    @ResponseBody
    @RequestMapping("/material/get/{materialId}")
    public Material updateMaterial(@PathVariable String materialId) {

        Material material = materialService.selectSingleMaterial(materialId);
        return material;
    }



    //显示修改MaterialNote的小窗口
    @ResponseBody
    @RequestMapping("/materialReceive/edit_judge")
    public String materialReceiveUpNote() {
        return null;
    }

    //修改note
    @ResponseBody
    @RequestMapping("/materialReceive/update_note")
    public Map materialUpdateNote(String receiveId,String note){
        materialService.updateMaterialReceiveNote(receiveId,note);

        Map<Object, Object> map = new HashMap();
        map.put("status", 200);
        map.put("msg", "OK");
        return map;
    }

    //修改MaterialReceiver的信息
    @RequestMapping("/materialReceive/edit")
    public String materialRece(){
        return "materialReceive_edit";
    }

    @ResponseBody
    @RequestMapping("/materialReceive/update_all")
    public Map materialReceUpdate(MaterialReceive materialReceive){
        materialService.updateReceMaterial(materialReceive);
        Map<Object, Object> map = new HashMap();
        map.put("status", 200);
        map.put("msg", "OK");
        return map;
    }

    //删除MaterialRece
    @ResponseBody
    @RequestMapping("/materialReceive/delete_judge")
    public String materialReceDeleteJudge(){
        return null;
    }


    @ResponseBody
    @RequestMapping("/materialReceive/delete_batch")
    public Map deleteAppear(String[] ids){

        materialService.deleteReceBench(ids);

        Map<Object, Object> map = new HashMap();
        map.put("status", 200);
        map.put("msg", "OK");
        return map;
    }

    //下面是MaterialRece的物料的模糊查询
    @ResponseBody
    @RequestMapping("/materialReceive/search_materialReceive_by_receiveId")
    public Map searchByReceiveId(String searchValue,String page,String rows){

        Map<String, Object> map = new HashMap<>();

        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(rows);

        //开始分页  内部通过修改sql语句
        PageHelper.startPage(pageNum, pageSize);


        List<MaterialReceive> sysPermissionList = materialService.searchByReceId(searchValue);

        //通过此处将list里的每个集合获取到里面对象引用
        for (MaterialReceive materialReceive : sysPermissionList) {
            Material material = materialService.selectSingleMaterial(materialReceive.getMaterialId());
            materialReceive.setMaterial(material);
        }

        PageInfo<MaterialReceive> materialPageInfo = new PageInfo<>(sysPermissionList, pageNum);
        long total = materialPageInfo.getTotal();

        map.put("rows", sysPermissionList);
        map.put("total", total);

        return map;

    }

    @ResponseBody
    @RequestMapping("/materialReceive/search_materialReceive_by_materialId")
    public Map searchByMaterialId(String searchValue,String page,String rows){

        Map<String, Object> map = new HashMap<>();

        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(rows);

        //开始分页  内部通过修改sql语句
        PageHelper.startPage(pageNum, pageSize);

        List<MaterialReceive> sysPermissionList = materialService.searchByMaterialID(searchValue);

        //通过此处将list里的每个集合获取到里面对象引用
        for (MaterialReceive materialReceive : sysPermissionList) {
            Material material = materialService.selectSingleMaterial(materialReceive.getMaterialId());
            materialReceive.setMaterial(material);
        }

        PageInfo<MaterialReceive> materialPageInfo = new PageInfo<>(sysPermissionList, pageNum);
        long total = materialPageInfo.getTotal();

        map.put("rows", sysPermissionList);
        map.put("total", total);

        return map;

    }

}
