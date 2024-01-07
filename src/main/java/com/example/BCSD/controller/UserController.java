package com.example.BCSD.controller;

import com.example.BCSD.auth.oauth.JwtTokenUtil;
import com.example.BCSD.domain.User;
import com.example.BCSD.domain.dto.LoginRequest;
import com.example.BCSD.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public User insertUser(@RequestBody User user) {return userService.insertUser(user);}

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        User user = userService.login(loginRequest);
        //System.out.println(user.getLoginId());
        //System.out.println(user.getUserPw());

        if (user == null) {
            return "아이디 또는 비밀번호가 일치하지 않습니다.";
        }
        // 로그인 성공
        String secretKey = "my-secret-key-123123";
        long expireTimeMs = 1000 * 60 * 60; //60분

        String jwtToken = JwtTokenUtil.createToken(user.getLoginId(), secretKey, expireTimeMs);

        return jwtToken;


    }

    @GetMapping("")
    public List<User> getAllUsers() {return userService.getAllUsers();}

    @GetMapping("/{id}")
    public User getUserByUserId(@PathVariable Integer id) {return userService.getUserByUserId(id);}

    @PutMapping("/{userid}")
    public void updateUser(@PathVariable String userid, @RequestBody User user) {userService.updateUser(userid, user);}

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {userService.deleteUser(id);}
}
