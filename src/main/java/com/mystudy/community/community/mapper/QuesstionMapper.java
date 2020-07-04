package com.mystudy.community.community.mapper;

import com.mystudy.community.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @描述
 * @创建人 CYH
 * @创建时间 2020/5/23
 */
@Mapper
public interface QuesstionMapper {

    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmt_create},#{gmt_modified},#{creator},#{tag})")
    void creat(Question question);

    @Select("select * from question limit #{offset},#{size} ")
    List<Question> list(Integer offset, Integer size);

    @Select("select count(1) from question")
    Integer count();
}
