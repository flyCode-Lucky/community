package com.mystudy.community.community.controller;

import com.mystudy.community.community.dao.QuestionMapper;
import com.mystudy.community.community.dto.QuestionDTO;
import com.mystudy.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @描述
 * @创建人 CYH
 * @创建时间 2021/3/23
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    //这种在路径中的花括号里写到的可以直接在方法中拿到
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Integer id,
                           Model model){
        QuestionDTO questionDTO = questionService.getById(id);
        model.addAttribute("question", questionDTO);
        return "question";
    }
}
