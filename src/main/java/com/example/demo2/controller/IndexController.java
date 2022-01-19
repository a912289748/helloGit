package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String login()
    {
        return "login";
    }

    @PostMapping("/login")//防止表单重复提交
    public String main(String username,String password){

        return "redirect:/main.html";
    }

    @GetMapping("/main.html")
    public String mainPage(){
        return "main";
    }
}
