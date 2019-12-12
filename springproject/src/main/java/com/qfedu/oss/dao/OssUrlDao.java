package com.qfedu.oss.dao;

import com.qfedu.oss.entity.OssUrl;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OssUrlDao {
    // 新增
    @Insert("insert into t_ossurl(objname, url, ctime, endtime) values(#{objname}, #{url}, now(), #{endtime})")
    int insert(OssUrl url);

    //查询
    @Select("select id, objname, url, ctime, endtime from t_ossurl order by id desc")
    @ResultType(OssUrl.class)
    List<OssUrl> selectAll();

    @Delete("delete from t_ossurl where objname=#{name}")
    int del(String name);

}
