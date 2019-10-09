package com.enlie.blog.service.impl;

import com.enlie.blog.dao.ArticleMapper;
import com.enlie.blog.entity.ArticleInfo;
import com.enlie.blog.entity.Content;
import com.enlie.blog.entity.Label;
import com.enlie.blog.service.ArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    ArticleMapper articleMapper;
    List<Label> labelList;
    List<ArticleInfo> articleInfoList;


    @Override
    public List<Label> getCategoryLabel(Integer categoryid) {
        labelList=articleMapper.getCategoryLabel(categoryid);
        if (labelList!=null){
            return labelList;
        }
        return null;
    }

    @Override
    public Integer addArticleInfo(ArticleInfo articleInfo) {
        articleMapper.insertArticleInfo(articleInfo);
        System.out.println("文章信息Id："+articleInfo.getId());
        return articleInfo.getId();
    }
    public Integer addArticleContent(Content content){
        articleMapper.insertArticleContent(content);
        System.out.println("文章内容id："+content.getId());
        return content.getId();
    }

    @Override
    public Integer getArticleInfoCount(String selectInfoName) {
        Integer count=articleMapper.getArticleInfoCount(selectInfoName);
        return count;
    }

    @Override
    public List<ArticleInfo> getArticleInfo(String selectInfoName,Integer currentPageNo,Integer pagesize) {
        articleInfoList=articleMapper.getArticleInfo(selectInfoName,(currentPageNo-1)*pagesize,pagesize);
        return articleInfoList;
    }

}
