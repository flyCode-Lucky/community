package com.mystudy.community.community.controller;

import com.mystudy.community.community.dao.QuestionMapper;
import com.mystudy.community.community.entity.Question;
import com.mystudy.community.community.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
public class PublishController {

    @Resource
    private QuestionMapper questionMapper;

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
        if(title.length()>=50){
            model.addAttribute("error", "标题过长，请用简洁的语言描述！");
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
        User user =(User) request.getSession().getAttribute("user");

        if(user==null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }


        //将准备好的question插入数据库
        questionMapper.creat(question);
        return "redirect:/";
    }

}
