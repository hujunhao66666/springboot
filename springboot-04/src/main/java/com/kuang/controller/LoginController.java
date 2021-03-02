package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession httpSession){

        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            httpSession.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }

        model.addAttribute("msg","用户名或者密码错误");
        return "index";
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:index";
    }
}
