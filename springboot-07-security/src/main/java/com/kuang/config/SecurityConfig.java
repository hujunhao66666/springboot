package com.kuang.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    //链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问
        //功能页只有对应权限的人才能访问
        //请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level2/**").hasRole("vip3");

        //没有权限跳转到登陆页面
        http.formLogin().loginPage("/toLogin");

        //注销功能实现

        //防止网站工具
        http.csrf().disable();
        http.logout().logoutSuccessUrl("/");

        //开启记住我功能 cookie,默认开启两周
        http.rememberMe().rememberMeParameter("remember");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("kuangshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");

    }
}
