package com.example.homework_9.controller;

import com.example.homework_9.dto.UserDTO;
import com.example.homework_9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("")
    public UserDTO insertUser(@RequestBody UserDTO user) {
        return userService.insertUser(user);
    }

    @GetMapping("")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userID}")
    public UserDTO getUserByUserID(@PathVariable String userID) {
        return userService.getUserByUserID(userID);
    }

    @PutMapping("/{userID}")
    public void updateUser(@PathVariable String userID, @RequestBody UserDTO user) {
        userService.updateUserPassword(userID, user);
    }

    @DeleteMapping("/{userID}")
    public void deleteUser(@PathVariable String userID) {
        userService.deleteUser(userID);
    }
}
