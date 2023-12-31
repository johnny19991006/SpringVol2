package com.example.SpringVol2.controller;

import com.example.SpringVol2.Service.UserServiceImpl;
import com.example.SpringVol2.domain.User;
import com.example.SpringVol2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<User> findUsers() {
        return userMapper.findUsers();
    }

    @GetMapping("/{email}")
    public User findUserByEmail(@PathVariable String email) {
        return userMapper.findUserByEmail(email);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        userMapper.createUser(user);
        return user;
    }

    @PutMapping("/{email}")
    public User updateUser(@PathVariable String email, @RequestBody User user) {
        userMapper.updateUser(user);
        return user;
    }

    @DeleteMapping("/{email}")
    public int deleteUser(@PathVariable String email) {
        return userMapper.deleteUser(email);
    }
}
