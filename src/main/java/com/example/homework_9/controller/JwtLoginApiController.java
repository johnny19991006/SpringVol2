package com.example.homework_9.controller;

import com.example.homework_9.domain.users.User;
import com.example.homework_9.dto.JoinRequest;
import com.example.homework_9.dto.LoginRequest;
import com.example.homework_9.jwt.JwtTokenUtil;
import com.example.homework_9.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class JwtLoginApiController {

    private final UserService userService;

    public JwtLoginApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join")
    public String join(@RequestBody JoinRequest joinRequest) {

        // loginId 중복 체크
        if (userService.checkUserIdDuplicate(joinRequest.getUserID())) {
            return "로그인 아이디가 중복됩니다.";
        }
        // 닉네임 중복 체크
        if (userService.checkNameDuplicate(joinRequest.getName())) {
            return "닉네임이 중복됩니다.";
        }
        // password, passwordCheck가 같은지 체크
        if (!joinRequest.getPassword().equals(joinRequest.getPassword())) {
            return "바밀번호가 일치하지 않습니다.";
        }

        userService.join(joinRequest);
        return "회원가입 성공";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {

        User user = userService.login(loginRequest);

        // 로그인 아이디나 비밀번호가 틀린 경우
        if (user == null) {
            return "로그인 아이디 또는 비밀번호가 틀렸습니다.";
        }

        // 로그인 성공 -> Jwt Token 발급

        String secretKey = "my-secret-key-123123";
        long expireTimeMs = 1000 * 60 * 60;     // Token 유효 시간 = 60분

        String jwtToken = JwtTokenUtil.createToken(user.getUserID(), secretKey, expireTimeMs);

        return jwtToken;
    }

    @GetMapping("/info")
    public String userInfo(Authentication auth) {
        User loginUser = userService.getLoginUserById(auth.name());

        return String.format("loginId : %s\nnickname : %s\nrole : %s",
                loginUser.getUserID(), loginUser.getName(), loginUser.getRole().name());
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "관리자 페이지 접근 성공";
    }
}

