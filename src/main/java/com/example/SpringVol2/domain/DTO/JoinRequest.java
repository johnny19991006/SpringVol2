package com.example.SpringVol2.domain.DTO;

import com.example.SpringVol2.domain.User;
import com.example.SpringVol2.domain.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JoinRequest {

    private String loginEmail;

    private String password;
    private String passwordCheck;

    public User toEntity() {
        User user = new User();
        user.setEmail(this.loginEmail);
        user.setPassword(this.password);
        user.setRole(UserRole.ROLE_USER);

        return user;
    }
}
