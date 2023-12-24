package bcsd.BoardAPI.controller;

import bcsd.BoardAPI.domain.User;
import bcsd.BoardAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") // 루트 url을 /users 로 매핑함. 보통 실무에서는 복수형으로 잡음.
public class UserController {

    @Autowired
    private UserService userService;

    // 코드들의 흐름을 보면 UserController에서는 요청을 받고 해당 요청을 UserSerivce로 전달해 최종 결과만을 리턴하고 있다.

    // 모든 유저 조회
    // uri : localhost:0000/users
    @GetMapping("")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    // 유저 아이디 조회
    // uri : localhost:0000/users/{userid}
    @GetMapping("/{userid}")
    public User getUserByUserid(@PathVariable String userid) {
        return userService.getUserByUserId(userid);
    }

    // 유저 등록
    // uri : localhost:0000/users
    @PostMapping("")
    @ResponseBody
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // 유저 수정
    // uri : localhost:0000/users/{userid}
    @PutMapping("/{userid}")
    public void modifyUser(@PathVariable String userid, @RequestBody User user) {
        userService.modifyUser(userid, user);
    }

    // 유저 삭제
    // uri : localhost:0000/users/{userid}
    @DeleteMapping("/{userid}")
    public void removeUser(@PathVariable String userid) {
        userService.removeUser(userid);
    }

}