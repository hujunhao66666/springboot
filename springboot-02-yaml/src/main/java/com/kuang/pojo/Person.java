package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "person")
@Validated//开启数据校验
public class Person {
    @Email(message = "邮箱格式错误")
    private String email;
    private String name;
    private int age;
    private Boolean happy;

    private Date birth;
    private Map<String ,Object> maps;
    private List<Object> lists;
    private Dog dog;



}
