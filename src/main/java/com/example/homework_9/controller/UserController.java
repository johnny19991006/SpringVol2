package com.example.homework_9.controller;

import com.example.homework_9.domain.users.User;
import com.example.homework_9.dto.UserDTO;
import com.example.homework_9.service.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServiceImplement userService;

    @PostMapping("")
    public User insertUser(@RequestBody UserDTO user) {
        return userService.insertUser(user);
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userID}")
    public User getUserByUserID(@PathVariable String userID) {
        return userService.getUserByUserID(userID);
    }

    @PutMapping("/{userID}")
    public void updateUser(@PathVariable String userID, @RequestBody String password) {
        userService.updateUserPassword(userID, password);
    }

    @DeleteMapping("/{userID}")
    public void deleteUser(@PathVariable String userID) {
        userService.deleteUser(userID);
    }
}
