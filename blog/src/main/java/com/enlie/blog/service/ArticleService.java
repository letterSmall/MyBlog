package com.enlie.blog.service;

import com.enlie.blog.entity.ArticleInfo;
import com.enlie.blog.entity.Content;
import com.enlie.blog.entity.Label;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface ArticleService {

//    获取栏目信息
    List<Label> getCategoryLabel(@Param("categoryid") Integer categoryid);

//    新增文章信息
    Integer addArticleInfo(ArticleInfo articleInfo);

//    新增文章内容
    Integer addArticleContent(Content content);

    Integer getArticleInfoCount(@Param("selectInfoName") String selectInfoName);

    List<ArticleInfo> getArticleInfo(@Param("selectInfoName") String selectInfoName,Integer currentPageNo,Integer pagesize);
}

