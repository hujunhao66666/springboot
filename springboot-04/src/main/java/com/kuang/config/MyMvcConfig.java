package com.kuang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");

        registry.addViewController("/main.html").setViewName("dashboard");

        registry.addViewController("/index.html").setViewName("index");

        //registry.addViewController("/404.html").setViewName("404");

        //registry.addViewController("/register.html").setViewName("register");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/css/*","/js/**","/img/**","/dashboard.html","/user/login");
    }
}
