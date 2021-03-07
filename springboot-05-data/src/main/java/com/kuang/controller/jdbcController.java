package com.kuang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
public class jdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/userList")
    @ResponseBody
    public List<Map<String,Object>> userList(){
        String sql="select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/addUser")
    public String addUser(){
        String sql="insert into mybatis.user values(9,'李若樱','123141')";
        jdbcTemplate.update(sql);
        return "redirect:/userList";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        String sql="update mybatis.user set name='范冰冰' where id=9";
        jdbcTemplate.update(sql);
        return "redirect:/userList";
    }

    @GetMapping("/insertUser2")
    public String insertUser2(){
        String sql="insert into mybatis.user values(?,?,?)";
        Object[] objects = new Object[3];
        objects[0]=10;
        objects[1]="李若彤";
        objects[2]="124112";
        jdbcTemplate.update(sql,objects);
        return "redirect:/userList";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql="delete from mybatis.user where id=?";
        jdbcTemplate.update(sql,id);
        return "redirect:/userList";
    }

}
