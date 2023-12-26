package CRUD.bcsdbeginner.controller;

import CRUD.bcsdbeginner.domain.UserDomain;
import CRUD.bcsdbeginner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    // CRUD
    // C -> POST
    // R -> GET
    // U -> PUT
    // D -> DELETE

    @PostMapping("")
    public UserDomain insertUser(@RequestBody UserDomain user){
        return userService.insertUser(user);
    }

    @GetMapping("")
    public List<UserDomain> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDomain getUserByUserId(@PathVariable String userId){
        return userService.getUserByUserId(userId);
    }

    @PutMapping("/{userId}")
    public void updateUserPw(@PathVariable String userId, @RequestBody UserDomain user){
        userService.updateUserPw(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId){
        userService.deleteUser(userId) ;
    }
}
