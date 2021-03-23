package com.mystudy.community.community.controller;

import com.mystudy.community.community.dto.PaginationDTO;
import com.mystudy.community.community.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;


@Controller
public class IndexController {

    @Resource
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name="page",defaultValue ="1") Integer page,
                        @RequestParam(name="size",defaultValue ="1") Integer size){


        //通过service层的方法将question和user合在一起的questionDTO整合起来
        PaginationDTO pagination = questionService.list(page,size);
        //添加到model里面，方便在html页面渲染
        model.addAttribute("pagination",pagination);

        return "index";
    }
}
