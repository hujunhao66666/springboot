package com.kuang.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆成功后，应该有用户的session
        Object username = request.getSession().getAttribute("loginUser");

        if (username==null){
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }


        return true;
    }


}
