package com.mystudy.community.community.service;

import com.mystudy.community.community.CommunityApplication;
import com.mystudy.community.community.dto.PaginationDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommunityApplication.class)
class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;

    private PaginationDTO paginationDTO;

    @Test
    void list() {
        Integer page=1;
        Integer size=2;
        paginationDTO =questionService.list(page,size);
        Assert.assertNotNull(paginationDTO);
    }
}