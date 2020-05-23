package com.mystudy.community.community.controller;

import com.mysql.cj.Session;
import com.mystudy.community.community.mapper.QuesstionMapper;
import com.mystudy.community.community.mapper.UserMapper;
import com.mystudy.community.community.model.Question;
import com.mystudy.community.community.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @描述
 * @创建人 CYH
 * @创建时间 2020/5/13
 */
@Controller
public class PublishController {

    @Resource
    private QuesstionMapper quesstionMapper;
    @Resource
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model){

        //配合html页面的  th:text="${title}" 来解决刷新就清空的问题
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        //后台数据校验
        if(title == null ||title==""){
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if(description == null ||description==""){
            model.addAttribute("error", "问题补充不能为空");
            return "publish";
        }
        if(tag == null ||tag==""){
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }

        //往question里填充数据
        Question question = new Question();
        //这三个是publish.html页面里写的参数，传过来直接用
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        //该条记录创建与修改时间
        question.setGmt_create(System.currentTimeMillis());
        question.setGmt_modified(question.getGmt_create());

        //获取user
        User user = null;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null&&cookies.length!=0){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("token")){
                    String token=cookie.getValue();
                    user = userMapper.findByToken(token);
                    if(user!=null){
                        request.getSession().setAttribute("user",user);
                        /* 发布者id */
                        question.setCreator(user.getId());
                    }
                    break;
                }
            }
        }

        if(user==null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }


        //将准备好的question插入数据库
        quesstionMapper.creat(question);
        return "redirect:/";
    }

}
