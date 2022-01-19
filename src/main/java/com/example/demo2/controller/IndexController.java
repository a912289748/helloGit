package com.example.demo2.controller;

import com.example.demo2.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String login()
    {
        return "login";
    }

    @PostMapping("/login")//防止表单重复提交
    public String main(User user, HttpSession session,Model model){
        if(!StringUtils.isEmpty(user.getUserName()) && "123456".equals(user.getPassword()))
        {
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }else
        {
            model.addAttribute("msg","账号密码错误");
            return  "login";
        }


    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){

        //拦截器 过滤器
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null)
        {
            return "main";
        }else{
            model.addAttribute("msg","请重新登陆");
            return "login";
        }

    }
}
