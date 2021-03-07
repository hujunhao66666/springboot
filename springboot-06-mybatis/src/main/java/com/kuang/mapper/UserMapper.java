package com.kuang.mapper;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    //增删改查
    List<User> queryUserList();
    User queryUserById(@Param("id") int id);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(@Param("id") int id);


}
