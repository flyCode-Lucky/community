package com.mystudy.community.community.dao;

import com.mystudy.community.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

    @Insert("insert into USER(NAME,ACCOUNT_ID,TOKEN,GMT_CREATE,GMT_MODIFIED,bio,avatar_url) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{bio},#{avatarUrl})")
    void insert(User user);//类的话直接写

    @Select("select * from USER where token = #{token} ")
    User findByToken(@Param("token") String token);//参数的话要加@Param()

    @Select("select * from USER where ID = #{Id} ")
    User findById(Integer creator);
}

