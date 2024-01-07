package com.example.BCSD.domain;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "loginId")
    private String loginId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userPw")
    private String userPw;

    //private UserRole role;

    // OAuth 로그인에 사용
    //private String provider;
    //private String providerId;
    @Builder
    public User(String loginId, String userName, String userPw) {
        this.loginId = loginId;
        this.userName = userName;
        this.userPw = userPw;
    }
}
