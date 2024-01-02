package SpringMVC.jdbc.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String userName;
    private String userId;
    private String userPw;

    public User() {

    }
}
