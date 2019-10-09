package com.enlie.blog.service;

import com.enlie.blog.dao.UserMapper;
import com.enlie.blog.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service(value = "userDetailService")
public class UserDetailService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Admin admin=userMapper.selectAdmin(s);
        if (admin==null){
            System.out.println(s+"错误");
            throw new UsernameNotFoundException("Username not found");
        }
        return new User(admin.getUsername(),admin.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

}
