package com.enlie.blog.entity;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;


public class ArticleInfo {
    private Integer id;
    private String title;
    private Timestamp updatetime;
    private Integer categoryId;
    private String keyword;
    private String des;
    private String label;
    private String prcture;
    private Date createdate;
    private String simpleContent;

    public String getSimpleContent() {
        return simpleContent;
    }

    public void setSimpleContent(String simpleContent) {
        this.simpleContent = simpleContent;
    }

    @Override
    public String toString() {
        return "ArticleInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", updatetime=" + updatetime +
                ", categoryId=" + categoryId +
                ", keyword='" + keyword + '\'' +
                ", des='" + des + '\'' +
                ", label='" + label + '\'' +
                ", prcture='" + prcture + '\'' +
                ", createdate=" + createdate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPrcture() {
        return prcture;
    }

    public void setPrcture(String prcture) {
        this.prcture = prcture;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
