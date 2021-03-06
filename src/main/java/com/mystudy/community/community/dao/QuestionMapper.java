package com.mystudy.community.community.dao;

import com.mystudy.community.community.dto.QuestionDTO;
import com.mystudy.community.community.entity.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmt_create},#{gmt_modified},#{creator},#{tag})")
    void creat(Question question);

    @Select("select * from question limit #{offset},#{size} ")
    List<Question> list(Integer offset, Integer size);

    @Select("select * from question where creator = #{userId} limit #{offset},#{size} ")
    List<Question> listByUserID(Integer userId ,Integer offset, Integer size);


    @Select("select count(1) from question")
    Integer count();

    @Select("select count(1) from question where creator = #{userId}")
    Integer countByUserId(Integer userId);


    @Select("select * from question where id = #{id} ")
    Question getById(Integer id);
}
