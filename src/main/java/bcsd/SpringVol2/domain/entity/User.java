package bcsd.SpringVol2.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String username; //유저 닉네임
    private String userid; //유저 아이디
    private String password; //유저 비밀번호

    public User(String username, String userid, String password) {
        this.username = username;
        this.userid = userid;
        this.password = password;
    }
}