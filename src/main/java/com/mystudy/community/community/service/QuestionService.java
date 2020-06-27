package com.mystudy.community.community.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.mystudy.community.community.dto.QuestionDTO;
import com.mystudy.community.community.mapper.QuesstionMapper;
import com.mystudy.community.community.mapper.UserMapper;
import com.mystudy.community.community.model.Question;
import com.mystudy.community.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @描述
 * @创建人 CYH
 * @创建时间 2020/6/27
 */
@Service
public class QuestionService {

    //准备好两个表的mapper（从数据库查询记录）
    @Resource
    private QuesstionMapper quesstionMapper;
    @Resource
    private UserMapper userMapper;

    /**
     *查出所有发布的提问，通过问题创建者找出他们对应的user，然后将question和user全部放到questionDTO里，循环得到集合questionDTOList
     * @return 带有user的问题列表
     */
    public List<QuestionDTO> list() {
        List<Question> questions = quesstionMapper.list();//查询出questionn表中所有的提问
        List<QuestionDTO> questionDTOList = new ArrayList<>();//准备好一个空的questionDTO列表
        //循环上面查出的所有问题，通过问题创建者将他们的user找出来和question一起加到questionDTO里面
        for(Question question :questions) {
            User user = userMapper.findById(question.getCreator());//通过创建者找出user
            QuestionDTO questionDTO =new QuestionDTO();//空的questionDTO
            BeanUtils.copyProperties(question,questionDTO);//将question全部映射到questionDTO里面
            questionDTO.setUser(user);//往questionDTO里面添加user对象
            questionDTOList.add(questionDTO);//将所有questionDTO添加到questionDTOList
        }
        return questionDTOList;
    }
}
