package com.kuang.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
        Locale aDefault = Locale.getDefault();//如果没有就使用默认的

        //如果请求的连接携带了国际化的参数
        if(!StringUtils.isEmpty(l)){
            String[] s = l.split("_");
            //国家，地区
            aDefault = new Locale(s[0], s[1]);

        }
        return aDefault;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
