package com.enlie.blog.entity;

import lombok.Data;

@Data
public class Content {
    private Integer id;
    private Integer infoId;
    private String content;
    private String cfile;

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", infoId=" + infoId +
                ", content='" + content + '\'' +
                ", cfile='" + cfile + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCfile() {
        return cfile;
    }

    public void setCfile(String cfile) {
        this.cfile = cfile;
    }
}
