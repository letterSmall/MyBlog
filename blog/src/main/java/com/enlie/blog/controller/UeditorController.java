package com.enlie.blog.controller;

import com.baidu.ueditor.ActionEnter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.enlie.blog.tool.ImageUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController

public class UeditorController {

    @ResponseBody
    @RequestMapping("/conig")
    public Object demo(HttpServletRequest request, HttpServletResponse response) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        String path = "//" + formater.format(new Date());
        String action = request.getParameter("action");
        String rPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/admin/ueditor/jsp";
        if (action.equals("uploadimage")) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartHttpServletRequest.getFile("upfile");
            String filePath =path;
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            String imgName = multipartFile.getOriginalFilename();
            String hz = imgName.substring(imgName.indexOf("."));
            String uuid = UUID.randomUUID().toString();
            String uuid1 = UUID.randomUUID().toString();
            uuid = uuid.replace("-", "");
            uuid1 = uuid1.replace("-", "");
            String name = filePath + "//" + uuid + hz;
            String fileName = filePath + "//" + uuid1 + hz;
            File f = new File(name);
            File f1 = new File(fileName);
            try {
                multipartFile.transferTo(f);
                InputStream inputStream = new FileInputStream(f);
                OutputStream os = new FileOutputStream(f1);
                ImageUtil.resizeImage(inputStream, os, 500, 750, hz.replace(".", ""));
                f.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(path + "//" + uuid1 + hz);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("original", multipartFile.getOriginalFilename());
            map.put("name", multipartFile.getOriginalFilename());
            map.put("url", path + "//" + uuid1 + hz);
            map.put("size", multipartFile.getSize());
            map.put("type", "." + hz);
            map.put("state", "SUCCESS");
            return map;
        } else {
            response.setContentType("application/json");
            try {
                response.setCharacterEncoding("utf-8");
                request.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                writer.write(new ActionEnter(request, rPath).exec());
                writer.flush();
                writer.close();
            } catch (Exception r) {
                r.printStackTrace();
            }
        }
        return null;
    }
}

