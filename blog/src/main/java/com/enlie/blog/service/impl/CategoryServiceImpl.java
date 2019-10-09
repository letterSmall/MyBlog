package com.enlie.blog.service.impl;

import com.enlie.blog.dao.CategoryMapper;
import com.enlie.blog.entity.Category;
import com.enlie.blog.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryMapper categoryMapper;

    @Override
    public int addCategory(String name, String aliasname, String keyword, String des) {

        return categoryMapper.addCategory(name,aliasname,keyword,des);
    }

    @Override
    public int deleteCategory(Integer id) {
        categoryMapper.deleteCategory(id);
        return categoryMapper.deleteCategory(id);
    }
}
