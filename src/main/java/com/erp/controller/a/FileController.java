package com.erp.controller.a;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/upload")
    @ResponseBody
    public Map upload(MultipartFile file, HttpServletRequest request) throws IOException {
        Map<String, Object> map = new HashMap<>();
        //原始文件名称
        String filename = file.getOriginalFilename();
        String storePath = "file/" + filename;
        String realPath = request.getRealPath(storePath);
        File uploadPic = new File(realPath);
        file.transferTo(uploadPic);
        map.put("error",0);
        map.put("url",storePath);
        return map;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(String fileName, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        String realPath = request.getRealPath(fileName);
        File uploadPic = new File(realPath);
        boolean delete = uploadPic.delete();
        if (delete) {
            map.put("data","success");
        }else {
            map.put("data","fail");
        }
        return map;
    }

    @RequestMapping("/download")
    public void download(String fileName, HttpServletResponse response, HttpServletRequest request) throws IOException {
        String realPath = request.getRealPath(fileName);
        //设置文件名编码
        String[] split = fileName.split("/");//去掉文件夹，取出文件名
        fileName = URLEncoder.encode(split[1], "UTF-8");
        response.setHeader( "Content-Disposition", "attachment;filename=" +fileName);

        //把文件用流的形式写出去
        FileInputStream fis = new FileInputStream(realPath);
        byte[] buffer = new byte[2048];
        int length = -1;
        while((length = fis.read(buffer)) != -1) {
            response.getOutputStream().write(buffer, 0, length);
        }
    }
}
