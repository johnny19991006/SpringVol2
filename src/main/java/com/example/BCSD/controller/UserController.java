package com.example.BCSD.controller;

import com.example.BCSD.domain.User;
import com.example.BCSD.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("")
    public User insertUser(@RequestBody User user) {return userService.insertUser(user);}

    @GetMapping("")
    public List<User> getAllUsers() {return userService.getAllUsers();}

    @GetMapping("/{id}")
    public User getUserByUserId(@PathVariable Integer id) {return userService.getUserByUserId(id);}

    @PutMapping("/{userid}")
    public void updateUser(@PathVariable String userid, @RequestBody User user) {userService.updateUser(userid, user);}

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {userService.deleteUser(id);}
}
