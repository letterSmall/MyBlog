package com.enlie.blog.controller.backController;

import com.enlie.blog.entity.Category;
import com.enlie.blog.service.impl.CategoryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CategoryController {
    @Resource
    CategoryServiceImpl categoryService;

    List<Category> getCategoryList=null;

    @GetMapping("/Category/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id){

        if (categoryService.deleteCategory(id)==0){
            return "redirect:/back/category";
        }
        return "redirect:/back/404";
    }

    @PostMapping("/Category/add")
    public String addCategory(Model model,
                              @RequestParam("name") String name,
                              @RequestParam("aliasname") String aliasname,
                              @RequestParam("keyword") String keyword,
                              @RequestParam("des") String des){
        System.out.println(name+aliasname+keyword+des);
        if (name==null || name.equals("")){
            model.addAttribute("msg","栏目名未填写");
            return "backstage/404";
        }
        if (aliasname==null || aliasname.equals("")){
            model.addAttribute("msg","栏目别名未填写");
            return "backstage/404";
        }
        categoryService.addCategory(name,aliasname,keyword,des);
        return "redirect:/back/category";
    }
}
