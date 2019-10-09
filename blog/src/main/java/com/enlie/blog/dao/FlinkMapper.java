package com.enlie.blog.dao;

import com.enlie.blog.entity.FLink;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FlinkMapper {
    @Select("select * from b_flink where linkname=#{linkname}")
    public FLink getFlinkName(@Param("linkname") String linkname);

    @Select("select * from b_flink")
    public List<FLink> getFlink();

    @Delete("delete from b_flink where id=#{id}")
    public int deleteFlink(Integer id);

    int addFlink(@Param("linkname") String linkname,
                 @Param("url") String url,
                 @Param("image") String image,
                 @Param("des") String des);
}
