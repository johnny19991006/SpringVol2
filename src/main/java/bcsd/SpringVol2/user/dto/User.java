package bcsd.SpringVol2.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String userName; //유저 닉네임
    private String userId; //유저 아이디
    private String password; //유저 비밀번호

    public User(String userName, String userId, String password) {
        this.userName = userName;
        this.userId = userId;
        this.password = password;
    }
}
