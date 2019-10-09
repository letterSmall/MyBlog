package com.enlie.blog.dao;

import com.enlie.blog.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from b_admin where username=#{username}")
    public Admin selectAdmin(String username);
}
