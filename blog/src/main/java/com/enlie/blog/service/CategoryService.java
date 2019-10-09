package com.enlie.blog.service;

import com.enlie.blog.entity.Category;
import org.apache.ibatis.annotations.Param;

public interface CategoryService {
    /**
     * 添加栏目
     * @param name
     * @param aliasname
     * @param keyword
     * @param des
     * @return
     */
    int addCategory(@Param("name") String name,
                         @Param("aliasname")String aliasname,
                         @Param("keyword")String keyword,
                         @Param("des")String des);

    int deleteCategory(@Param("id") Integer id);


}
