package com.example.SpringVol2.controller;

import com.example.SpringVol2.Service.UserService;
import com.example.SpringVol2.domain.DTO.JoinRequest;
import com.example.SpringVol2.domain.DTO.LoginRequest;
import com.example.SpringVol2.domain.User;
import com.example.SpringVol2.security.JwtTokenFilter;
import com.example.SpringVol2.security.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jwt-login")
public class JwtLoginApiController {
    ;
    public final UserService userService;

    @PostMapping("/join")
    public String join(@RequestBody JoinRequest joinRequest) {
        // ㅇ
        if(userService.checkEmailDuplicate(joinRequest.getLoginEmail())) {
            return "로그인 아이디가 중복됩니다";
        }

        // password와 passwordCheck가 같은지 확인
        if(!joinRequest.getPassword().equals(joinRequest.getPasswordCheck())) {
            return "비밀번호가 일치하지 않습니다";
        }

        userService.join(joinRequest);
        return "회원가입 성공";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        User user = userService.login(loginRequest);

        // 로그인 아이디나 비밀번호가 틀렸을 경우
        if(user == null) {
            return "로그인 아이디나 비밀번호가 틀렸습니다";
        }

        // 로그인 성공 =? Jwt Token 발급
        String secretKey = "my-secret-key-123456";
        long expireTimeMs = 1000 * 60 * 60; // token 유효 시간 60분

        String jwtToken = JwtTokenUtil.createToken(user.getEmail(), secretKey, expireTimeMs);

        return jwtToken;
    }

    @GetMapping("/info")
    public String userInfo(Authentication auth) {
        User loginUser = userService.getLoginUserByEmail(auth.getName());

        return String.format("email : %s\nrole : %s ",
                loginUser.getEmail(), loginUser.getRole().name());
    }
}
