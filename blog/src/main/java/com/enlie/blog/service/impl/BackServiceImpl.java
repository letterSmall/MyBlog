package com.enlie.blog.service.impl;

import com.enlie.blog.dao.CategoryMapper;
import com.enlie.blog.dao.FlinkMapper;
import com.enlie.blog.entity.Category;
import com.enlie.blog.entity.FLink;
import com.enlie.blog.service.BackService;
import com.enlie.blog.tool.CheckUrl;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.URL;
import java.util.List;

@Service
public class BackServiceImpl implements BackService {


    FLink fLink;
    @Resource
    private FlinkMapper flinkMapper;
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public FLink addFlink(String linkname, String url, String image, String des) {
        CheckUrl checkUrl=new CheckUrl();
        if (checkUrl.exists(url)==null){
            System.out.println("url错误");
            return null;
        }
        if (checkUrl.exists(image)==null){
            System.out.println("image错误");
            return null;
        }
        if (flinkMapper.getFlinkName(linkname)!=null){
            System.out.println("已经存在");
            return fLink;
        }
        flinkMapper.addFlink(linkname,url,image,des);
        return null;
    }

    @Override
    public List<FLink> getFLinkList() {
        return flinkMapper.getFlink();
    }

    @Override
    public List<Category> getCategory() {
        return categoryMapper.getCategory();
    }
}
