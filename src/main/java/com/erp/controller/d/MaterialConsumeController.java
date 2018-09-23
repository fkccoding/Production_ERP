package com.erp.controller.d;

import com.erp.bean.Material;
import com.erp.bean.MaterialConsume;
import com.erp.bean.MaterialReceive;
import com.erp.bean.Work;
import com.erp.service.a.WorkService;
import com.erp.service.d.MaterialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MaterialConsumeController {
    @Autowired
    MaterialService materialService;

    @Autowired
    WorkService workService;

    @RequestMapping("/materialConsume/find")
    public String materialConsumeAppear(){
        return "materialConsume_list";
    }


    @ResponseBody
    @RequestMapping("/materialConsume/list")
    public Map doSearch_materialConsume(){

        Map<String,Object> map = new HashMap<>();
        //利用materialService获取到物料的list集合
        List<MaterialConsume> materialConsumes = materialService.materialConsumeList();

        for (MaterialConsume materialConsume : materialConsumes) {

            /**获取material的ID 并填充在MaterialConsume中 */
            String materialId = materialConsume.getMaterialId();
            Material material = materialService.selectSingleMaterial(materialId);
            materialConsume.setMaterial(material);

            /**获取work的ID 并填充在MaterialConsume中 */
            String workId = materialConsume.getWorkId();
            Work work = workService.findById(workId);
            materialConsume.setWork(work);

        }
        map.put("rows",materialConsumes);
        map.put("total",materialConsumes.size());
        return map;
    }

    //显示修改MaterialConsumeNote的小窗口
    @ResponseBody
    @RequestMapping("/materialConsume/edit_judge")
    public String materialConsumeUpNote() {
        return null;
    }

    //修改note
    @ResponseBody
    @RequestMapping("/materialConsume/update_note")
    public Map materialUpdateNote(String consumeId,String note){

        materialService.updateMaterialConsumeNote(consumeId,note);

        Map<Object, Object> map = new HashMap();
        map.put("status", 200);
        map.put("msg", "OK");
        return map;
    }

    //显示增加MaterialConsume的小窗口
    @RequestMapping(value = {"/materialConsume/add_judge","/materialConsume/add"})
    public String materialReceiveAddJudge() {
        return "materialConsume_add";
    }

    /**
     * 在添加MaterialConsume materialConsume
     */
    @ResponseBody
    @RequestMapping("/materialConsume/insert")
    public Map insertMaterialReceive(MaterialConsume materialConsume) {
        Map<Object, Object> map = new HashMap();

        materialService.insertMaterialConsume(materialConsume);

        map.put("status", 200);
        map.put("msg", "OK");

        return map;
    }

    /**  修改MaterialRece的物料信息 */

    //修改MaterialReceiver的信息
    @RequestMapping("/materialConsume/edit")
    public String materialRece(){
        return "materialConsume_edit";
    }

    @ResponseBody
    @RequestMapping("/materialConsume/update_all")
    public Map materialReceUpdate(MaterialConsume materialConsume){
        materialService.updateMaterialConsume(materialConsume);
        Map<Object, Object> map = new HashMap();
        map.put("status", 200);
        map.put("msg", "OK");
        return map;
    }

    /**  批量删除MaterialRece的物料信息 */

    //删除MaterialRece
    @ResponseBody
    @RequestMapping("/materialConsume/delete_judge")
    public String materialReceDeleteJudge(){
        return null;
    }

    @ResponseBody
    @RequestMapping("/materialConsume/delete_batch")
    public Map deleteAppear(String[] ids){

        materialService.deleteConsumeBench(ids);

        Map<Object, Object> map = new HashMap();
        map.put("status", 200);
        map.put("msg", "OK");
        return map;
    }

    /**  下面是MaterialConsume的模糊查询 */

    @ResponseBody
    @RequestMapping("/materialConsume/search_materialConsume_by_consumeId")
    public Map searchByReceiveId(String searchValue,String page,String rows){

        Map<String, Object> map = new HashMap<>();

        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(rows);

        //开始分页  内部通过修改sql语句
        PageHelper.startPage(pageNum, pageSize);

        List<MaterialConsume> materialConsumes = materialService.searchByConsumeID(searchValue);

        for (MaterialConsume materialConsume : materialConsumes) {

            /**获取material的ID 并填充在MaterialConsume中 */
            String materialId = materialConsume.getMaterialId();
            Material material = materialService.selectSingleMaterial(materialId);
            materialConsume.setMaterial(material);

            /**获取work的ID 并填充在MaterialConsume中 */
            String workId = materialConsume.getWorkId();
            Work work = workService.findById(workId);
            materialConsume.setWork(work);

        }
        PageInfo<MaterialConsume> materialPageInfo = new PageInfo<>(materialConsumes, pageNum);
        long total = materialPageInfo.getTotal();

        map.put("rows", materialConsumes);
        map.put("total", total);
        return map;
    }

    @ResponseBody
    @RequestMapping("/materialConsume/search_materialConsume_by_workId")
    public Map searchByWorkId(String searchValue,String page,String rows){

        Map<String, Object> map = new HashMap<>();

        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(rows);

        //开始分页  内部通过修改sql语句
        PageHelper.startPage(pageNum, pageSize);

        List<MaterialConsume> materialConsumes = materialService.searchByWorkID(searchValue);

        for (MaterialConsume materialConsume : materialConsumes) {

            /**获取material的ID 并填充在MaterialConsume中 */
            String materialId = materialConsume.getMaterialId();
            Material material = materialService.selectSingleMaterial(materialId);
            materialConsume.setMaterial(material);

            /**获取work的ID 并填充在MaterialConsume中 */
            String workId = materialConsume.getWorkId();
            Work work = workService.findById(workId);
            materialConsume.setWork(work);

        }
        PageInfo<MaterialConsume> materialPageInfo = new PageInfo<>(materialConsumes, pageNum);
        long total = materialPageInfo.getTotal();

        map.put("rows", materialConsumes);
        map.put("total", total);
        return map;
    }



    @ResponseBody
    @RequestMapping("/materialConsume/search_materialConsume_by_materialId")
    public Map searchByMaterialId(String searchValue,String page,String rows){

        Map<String, Object> map = new HashMap<>();

        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(rows);

        //开始分页  内部通过修改sql语句
        PageHelper.startPage(pageNum, pageSize);

        List<MaterialConsume> materialConsumes = materialService.searchByMarerialID(searchValue);

        for (MaterialConsume materialConsume : materialConsumes) {

            /**获取material的ID 并填充在MaterialConsume中 */
            String materialId = materialConsume.getMaterialId();
            Material material = materialService.selectSingleMaterial(materialId);
            materialConsume.setMaterial(material);

            /**获取work的ID 并填充在MaterialConsume中 */
            String workId = materialConsume.getWorkId();
            Work work = workService.findById(workId);
            materialConsume.setWork(work);

        }
        PageInfo<MaterialConsume> materialPageInfo = new PageInfo<>(materialConsumes, pageNum);
        long total = materialPageInfo.getTotal();

        map.put("rows", materialConsumes);
        map.put("total", total);
        return map;
    }

}
