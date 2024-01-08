package bcsd.SpringVol2.controller;

import bcsd.SpringVol2.domain.entity.User;
import bcsd.SpringVol2.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void insertUser(@RequestBody User user){
        userService.insertUser(user);
    }

    @GetMapping("")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable(name = "id") Long id){
        return userService.findById(id);
    }

    @GetMapping("/name/{username}")
    public User findByUserName(@PathVariable(name = "username") String username){
        return userService.findByName(username);
    }

    @GetMapping("/id/{userid}")
    public User findByUserId(@PathVariable(name = "userid") String userid){
        return userService.findByUserId(userid);
    }

    @PutMapping("/{id}")
    public void updateUserName(@PathVariable(name = "id") Long id, @RequestBody User user){
        userService.updateUserInfo(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id){
        userService.deleteUser(id);
    }
}