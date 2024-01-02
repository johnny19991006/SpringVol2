package bcsdbeginner.demo.jdbc.Controller;

import bcsdbeginner.demo.jdbc.Domain.User;
import bcsdbeginner.demo.jdbc.Service.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImplement service;

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping("")
    public List<User> findAllUser() {
        return service.findAllUser();
    }

    @GetMapping("/{userId}")
    public User findById(String userId) {
        return service.findById(userId);
    }

    @PutMapping("/{userId}")
    public void updateUserName(String userId, String userName) {
        service.updateUserName(userId, userName);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(String userId) {
        service.deleteUser(userId);
    }
}
