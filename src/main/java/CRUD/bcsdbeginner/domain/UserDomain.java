package CRUD.bcsdbeginner.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDomain {
    private String userName;
    private String userId;
    private String userPw;
}
