package com.enlie.blog.controller.backController;

import com.alibaba.fastjson.JSON;
import com.baidu.ueditor.ActionEnter;
import com.enlie.blog.tool.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UeditorServerController {
    @RequestMapping("/config")
    public void config(HttpServletRequest request, HttpServletResponse response, MultipartFile upfile) {
        response.setContentType("application/json");
        response.setHeader("Content-Type", "text/html");
        String rooPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/backstage/lib/ueditor/jsp";
        String imgUditorPath = "C:/Users/EL/Desktop/blog/target/classes/static/backstage/lib/ueditor/jsp/upload/image/";
        String value = request.getParameter("action");
        if ("uploadimage".equals(value)) {
            String originalFilename = upfile.getOriginalFilename();
            String type = originalFilename.substring(originalFilename.indexOf("."), originalFilename.length());
            long size = upfile.getSize();
            System.out.println("originalFilename" + originalFilename);
            String middlePath = DateFormatUtils.format(new Date(), "yyyyMMdd") + "/";
            System.out.println("middlePate: " + middlePath);
            String fileFullName = imgUditorPath + middlePath + originalFilename;
            System.out.println("fileFullName：" + fileFullName);
            String url = "/backstage/lib/ueditor/jsp/upload/image/" + middlePath + originalFilename;
            System.out.println("URL：" + url);
            try {
                File file = new File(fileFullName);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                upfile.transferTo(file);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", "SUCCESS");
                map.put("original", originalFilename);
                map.put("size", size);
                map.put("title", originalFilename);
                map.put("type", type);
                map.put("url", url);
                String result = JSON.toJSONString(map);
                System.out.println("result : " + result);
                PrintWriter writer = response.getWriter();
                writer.write(result);
                writer.flush();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if ("config".equals(value)) {
            try {
                response.setCharacterEncoding("UTF-8");
                String exec = new ActionEnter(request, rooPath).exec();
                System.out.println(exec);
                PrintWriter writer = response.getWriter();
                writer.write(new ActionEnter(request, rooPath).exec());
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if ("listimage".equals(value)) {
            try {
                response.setCharacterEncoding("UTF-8");
                String rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/backstage/lib";
                String exec = new ActionEnter(request, rooPath).exec();

                System.out.println("exec：" + exec);
                PrintWriter writer = response.getWriter();
                writer.write(new ActionEnter(request, "http://127.0.0.1:8081").exec());
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("action：" + value);
        System.out.println("rootPath：" + rooPath);

    }
}
