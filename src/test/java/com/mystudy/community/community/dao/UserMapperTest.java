package com.mystudy.community.community.dao;

import com.mystudy.community.community.CommunityApplication;
import com.mystudy.community.community.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommunityApplication.class)
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void findByToken() {
        User user= userMapper.findByToken("17820a01-a563-4ecd-9c09-9d5a038b230a");
        Assert.assertNotNull(user);
    }

    @Test
    void findById() {
        User user= userMapper.findById(125456);
        Assert.assertNotNull(user);
    }
}