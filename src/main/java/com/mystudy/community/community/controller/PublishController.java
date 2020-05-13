package com.mystudy.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @描述
 * @创建人 CYH
 * @创建时间 2020/5/13
 */
@Controller
public class PublishController {

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

}
