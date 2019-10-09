package com.enlie.blog.controller.backController;

import com.enlie.blog.entity.ArticleInfo;
import com.enlie.blog.entity.Category;
import com.enlie.blog.entity.Content;
import com.enlie.blog.entity.Label;
import com.enlie.blog.service.ArticleService;
import com.enlie.blog.service.BackService;
import com.enlie.blog.tool.HtmlLabelFilter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {


    @Resource
    private BackService backService;
    @Resource
    private ArticleService articleService;

    List<Category> categoryList;
    List<Label> labelList;

    @RequestMapping("/back/add-article")
    public String add_article(Model model){
        categoryList=backService.getCategory();
        model.addAttribute("category",categoryList);
        return "backstage/add-article";
    }

    @PostMapping("/Article/add")
    @ResponseBody
    public String addArticle(@RequestParam(value = "title") String title,
                             @RequestParam(value = "content") String content,
                             @RequestParam(value = "keywords",required = false) String keyword,
                             @RequestParam(value = "des",required = false) String des,
                             @RequestParam(value = "category") Integer categoryId,
                             @RequestParam(value = "check",required = false) ArrayList label,
                             @RequestParam(value = "prcture",required = false) String prcture,
                             @RequestParam(value = "cfile",required = false) String cfile){
//      保存文章信息
        ArticleInfo articleInfo=new ArticleInfo();
        articleInfo.setTitle(title);
        articleInfo.setKeyword(keyword);
        articleInfo.setDes(des);
        articleInfo.setCategoryId(categoryId);
        String simpleContent=HtmlLabelFilter.htmlLabelFilter(content);
        articleInfo.setSimpleContent(simpleContent);
        System.out.println(articleInfo.toString());
//      获取新文章信息的id
        Integer infoId=articleService.addArticleInfo(articleInfo);
        if (infoId!=null){
            Content content1=new Content();
            content1.setInfoId(infoId);
            content1.setContent(content);
            content1.setCfile(cfile);
            Integer contentId=articleService.addArticleContent(content1);
        }else {
            return "redirect:/back/404";
        }


        return content;
    }

    @PostMapping("/article/label")
    @ResponseBody
    public List<Label> getArticleLabel( @RequestParam("category_id") Integer category_id){
        labelList= articleService.getCategoryLabel(category_id);
        return labelList;
    }
}
