package com.enlie.blog.service;

import com.enlie.blog.entity.Category;
import com.enlie.blog.entity.FLink;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BackService {
    /**
     * 添加友情链接
     * @param linkname
     * @param url
     * @param image
     * @param des
     * @return
     */
    FLink addFlink(@Param("linkname") String linkname,
                   @Param("url") String url,
                   @Param("image") String image,
                   @Param("des") String des);

    List<FLink> getFLinkList();

    List<Category> getCategory();
}
