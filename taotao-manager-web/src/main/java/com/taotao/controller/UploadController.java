package com.taotao.controller;

import com.alibaba.fastjson.JSON;
import com.taotao.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * @Author fengjie
 * @Description
 * @Date Created in 2017/12/6
 * @Time 11:10
 */
@Controller
public class UploadController {
    @Value("${IMAGE_SERVER_URL}")
    private String imageServer;
    @RequestMapping("/pic/upload")
    @ResponseBody
    public String upload(MultipartFile uploadFile){
        /*获取文件的扩展名*/
        String originalFileName = uploadFile.getOriginalFilename();
        String extName = originalFileName.substring(originalFileName.lastIndexOf(".")+1);
        try{
            FastDFSClient client = new FastDFSClient("classpath:properties/client.conf");
            String path = client.uploadFile(uploadFile.getBytes(),extName);
            String url = imageServer+path;
            Map<String,Object> result = new HashMap<>();
            result.put("error",0);
            result.put("url",url);
            String r = JSON.toJSONString(result);
            return r;
        } catch (Exception e){
            e.printStackTrace();
            Map<String,Object> result = new HashMap<>();
            result.put("error",1);
            result.put("message","图片上传失败");
            return JSON.toJSONString(result);
        }
    }
}
