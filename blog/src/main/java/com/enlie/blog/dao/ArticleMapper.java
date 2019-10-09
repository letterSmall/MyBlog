package com.enlie.blog.dao;

import com.enlie.blog.entity.ArticleInfo;
import com.enlie.blog.entity.Content;
import com.enlie.blog.entity.Label;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {


//    @Select("select * from b_ilabel where category_id=#{Category_id}")
    public List<Label> getCategoryLabel(@Param("categoryid") Integer categoryid);

    public int insertArticleInfo( ArticleInfo articleInfo);

    public int insertArticleContent(Content content);

    public int getArticleInfoCount(String selectInfoName);

    public List<ArticleInfo> getArticleInfo(@Param("selectInfoName") String selectInfoName,
                                            @Param("currentPageNo") Integer currentPageNo,
                                            @Param("pagesize") Integer pagesize);
}
