package com.mystudy.community.community.dao;

import com.mystudy.community.community.CommunityApplication;
import com.mystudy.community.community.entity.Question;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommunityApplication.class)
class QuestionMapperTest {

    @Autowired
    QuestionMapper questionMapper;

    @Test
    void count() {
        Integer count= questionMapper.count();
        //System.out.println(count);
        assert count!=null;
    }

    @Test
    void list(){
        Integer page=2;
        Integer size=1;
        List<Question> result= questionMapper.list(page,size);
        Assert.assertEquals(1,result.size());
    }
    
    @Test
    void getById(){
        Integer id=11;
        Question question = questionMapper.getById(id);
        Assert.assertNotNull(question.getId());
    }
    

}