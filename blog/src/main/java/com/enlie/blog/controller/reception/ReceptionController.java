package com.enlie.blog.controller.reception;

import com.enlie.blog.entity.FLink;
import com.enlie.blog.service.BackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ReceptionController {
    @Resource
    BackService backService;


    @RequestMapping("index")
    public String index(){
        return "reception/index";
    }
    @RequestMapping("blog/links")
    public String blogFlin(Model model){
        List<FLink> fLinkList=null;
        fLinkList=backService.getFLinkList();
        model.addAttribute("links",fLinkList);
        return "reception/links";
    }
}
