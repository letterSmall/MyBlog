package com.enlie.blog.entity;

import lombok.Data;

@Data
public class Admin {
    private int id;
    private String username;
    private String password;
    private String adminName;
    private String roles;


}
