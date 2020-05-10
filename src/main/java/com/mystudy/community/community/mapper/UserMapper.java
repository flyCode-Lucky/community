package com.mystudy.community.community.mapper;

import com.mystudy.community.community.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;

/**
 * @描述
 * @创建人 ChenYuHuan
 * @创建时间 2020/5/10
 */
@Mapper
public interface UserMapper {

    @Insert("insert into USER(NAME,ACCOUNT_ID,TOKEN,GMT_CREATE,GMT_MODIFIED) values(#{name},#{accountId},#{token},#{gmtCreat},#{gmtModified})")
    void insert(User user);
}

