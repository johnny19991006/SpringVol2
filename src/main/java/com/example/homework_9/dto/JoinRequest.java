package com.example.homework_9.dto;

import com.example.homework_9.domain.users.User;
import jakarta.validation.constraints.NotBlank;

public class JoinRequest {

    public JoinRequest() {

    }

    @NotBlank(message = "로그인 아이디가 비어있습니다.")
    private String userid;

    @NotBlank(message = "이름이 비어있습니다.")
    private String name;

    @NotBlank(message = "비밀번호가 비어있습니다.")
    private String password;

    public User toEntity(String encodedPassword) {
        return User.builder()
                .userid(this.userid)
                .password(encodedPassword)
                .name(this.name)
                .build();
    }

    public String getUserID() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setUserID(String userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
