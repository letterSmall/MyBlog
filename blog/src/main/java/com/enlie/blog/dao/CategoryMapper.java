package com.enlie.blog.dao;

import com.enlie.blog.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("select * from b_category")
    List<Category> getCategory();

    int addCategory(@Param("name") String name,
                    @Param("aliasname") String aliasname,
                    @Param("keyword") String keyword,
                    @Param("des") String des);

    @Delete("delete from b_category where id=#{id}")
    public int deleteCategory(Integer id);

}
