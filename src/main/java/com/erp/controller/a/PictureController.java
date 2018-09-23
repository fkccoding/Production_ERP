package com.erp.controller.a;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pic")
public class PictureController {

    @RequestMapping("/upload")
    @ResponseBody
    public Map upload(String dir, MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        Map<String, Object> map = new HashMap<>();
        //原始文件名称
        String pictureFilename = uploadFile.getOriginalFilename();
        String storePath = dir + "/upload/" + pictureFilename;
        String realPath = request.getRealPath(storePath);
        File uploadPic = new File(realPath);
        uploadFile.transferTo(uploadPic);
        map.put("error",0);
        map.put("url",storePath);
        return map;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(String picName, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        String realPath = request.getRealPath(picName);
        File uploadPic = new File(realPath);
        boolean delete = uploadPic.delete();
        if (delete) {
            map.put("data","success");
        }else {
            map.put("data","fail");
        }
        return map;
    }
}
