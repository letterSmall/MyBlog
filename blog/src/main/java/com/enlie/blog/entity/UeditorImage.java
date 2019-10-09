package com.enlie.blog.entity;

public class UeditorImage {
    private String state;
    private String url;
    private String title;
    private String original;

    @Override
    public String toString() {
        return "UeditorImage{" +
                "state='" + state + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", original='" + original + '\'' +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }
}
