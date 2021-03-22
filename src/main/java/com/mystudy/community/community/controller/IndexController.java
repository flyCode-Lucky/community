package com.mystudy.community.community.controller;

import com.mystudy.community.community.dto.PaginationDTO;
import com.mystudy.community.community.dao.UserMapper;
import com.mystudy.community.community.entity.User;
import com.mystudy.community.community.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
public class IndexController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name="page",defaultValue ="1") Integer page,
                        @RequestParam(name="size",defaultValue ="1") Integer size){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null&&cookies.length!=0){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user =userMapper.findByToken(token);
                    //登陆成功
                    if(user !=null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }

        //通过service层的方法将question和user合在一起的questionDTO整合起来
        PaginationDTO pagination = questionService.list(page,size);
        //添加到model里面，方便在html页面渲染
        model.addAttribute("pagination",pagination);

        return "index";
    }
}
