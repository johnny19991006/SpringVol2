package bcsd.SpringVol2.user.controller;

import bcsd.SpringVol2.user.dto.User;
import bcsd.SpringVol2.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String userTest(){
        User userA = new User("홍길동", "kk1234", "aa3333");
        User userB = new User("김철수", "jj1234", "bb3333");

        userService.insertUser(userA);
        userService.insertUser(userB);

        User userC = userService.findById(userA.getId());
        User userD = userService.findById(userB.getId());

        System.out.println(userC.getId() + userC.getUsername() + userC.getUserid() + userC.getPassword());
        System.out.println(userD.getId() + userD.getUsername() + userD.getUserid() + userD.getPassword());

        return "Ok";
    }

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

    @PutMapping
    public void updateUsername(@RequestBody User user){
        userService.updateUserInfo(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
