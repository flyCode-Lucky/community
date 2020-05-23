package com.mystudy.community.community.mapper;

import com.mystudy.community.community.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @描述
 * @创建人 ChenYuHuan
 * @创建时间 2020/5/10
 */
@Mapper
public interface UserMapper {

    @Insert("insert into USER(NAME,ACCOUNT_ID,TOKEN,GMT_CREATE,GMT_MODIFIED,bio,avatar_url) values(#{name},#{accountId},#{token},#{gmtCreat},#{gmtModified},#{bio},#{avatarUrl})")
    void insert(User user);//类的话直接写

    @Select("select * from USER where token = #{token} ")
    User findByToken(@Param("token") String token);//参数的话要加@Param()


}

