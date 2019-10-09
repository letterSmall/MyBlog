package com.enlie.blog.controller.backController;

import com.enlie.blog.entity.ArticleInfo;
import com.enlie.blog.entity.Category;
import com.enlie.blog.entity.FLink;
import com.enlie.blog.service.ArticleService;
import com.enlie.blog.service.BackService;
import com.enlie.blog.tool.Constants;
import com.enlie.blog.tool.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("back")
public class BackController {
    @Resource
    private BackService backService;
    @Resource
    private ArticleService articleService;

    List<FLink> fLinkList=null;
    List<Category> categoryList=null;
    List<ArticleInfo> articleInfoList=null;
    @RequestMapping("index")
    public String index(){
        return "backstage/index";
    }
    @RequestMapping("loginlog")
    public String loginlog(){
        return "backstage/loginlog";
    }
    @GetMapping("article")
    public String article(Model model,
                          @RequestParam(value = "maxTotalPage",required = false) Integer maxTotalPage,
                          @RequestParam(value = "pageIndex",required = false) Integer pageIndex,
                          @RequestParam(value = "selectInfoName",required = false) String selectInfoName){
//        当前记录数
        Integer count=1;
//        当前页码
        Integer currentPageNo=1;
        count=articleService.getArticleInfoCount(selectInfoName);
//        页码容量
        Integer pagesize= Constants.PAGESIZE;
        if (maxTotalPage!=null && pageIndex>maxTotalPage){
            pageIndex=maxTotalPage;
        }
        if (pageIndex!=null && pageIndex>=1 && pageIndex!=' '){
            currentPageNo=pageIndex;
        }
        PageSupport pageSupport=new PageSupport();
        pageSupport.setPageSize(pagesize);
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setTotalCount(count);
        Integer totalPageCount=pageSupport.getTotalPageCount();
        articleInfoList=articleService.getArticleInfo(selectInfoName,currentPageNo,pagesize);
        //控制首页和尾页
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }

        model.addAttribute("pages",pageSupport);
        model.addAttribute("articleInfo",articleInfoList);
        return "backstage/article";
    }


    @RequestMapping("category")
    public String category(Model model){
        categoryList=backService.getCategory();
        model.addAttribute("category",categoryList);
        return "backstage/category";
    }

    /**
     * 友情链接列表显示
     * @param model
     * @return
     */
    @GetMapping("/flink")
    public String flink(Model model){

        fLinkList=backService.getFLinkList();
        model.addAttribute("links",fLinkList);
        return "backstage/flink";
    }

    /**
     * 添加友情链接
     * @param linkname
     * @param url
     * @param image
     * @param des
     * @return
     */
    @PostMapping("/Flink/add")
    public String add_flink(@RequestParam("linkname") String linkname,
                            @RequestParam("url") String url,
                            @RequestParam("image") String image,
                            @RequestParam("des") String des){
        if (linkname==null||linkname.equals("")){
            return "redirect:/back/404";
        }
        if (url==null||url.equals("")){
            return "redirect:/back/404";
        }
        if (image==null||image.equals("")){
            return "redirect:/back/404";
        }
        backService.addFlink(linkname,url,image,des);
        return "redirect:/back/flink";
    }
}
