package com.enlie.blog.controller.backController;

import com.enlie.blog.service.FLinkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("back")
public class FLinkController {
    @Resource
    private FLinkService fLinkService;
    @PostMapping("deleteLink")
    public String batch_delete_flink(){
        return "redirect:/back/flink";
    }
    @GetMapping("/flinkdelete/{id}")
    public String delete_flink(@PathVariable("id") Integer id){
        if (fLinkService.deleteFlink(id)!=0){
            return "redirect:/back/404";
        }
        return "redirect:/back/flink";
    }

}
