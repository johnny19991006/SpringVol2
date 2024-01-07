package com.example.SpringVol2.mapper;

import com.example.SpringVol2.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> findUsers();

    @Select("SELECT * FROM users WHERE email = #{email}")
    User findUserByEmail(String email);

    @Insert("INSERT INTO users(email, userId ,password) VALUES (#{email}, #{userId}, #{password})")
    User createUser(User user);

    @Update("UPDATE users SET userId=#{userId}, password=#{password} WHERE email=#{email}")
    User updateUser(User user);

    @Delete("DELETE FROM users WHERE email=#{email}")
    int deleteUser(String email);
}
