package bcsdbeginner.demo.jdbc.Domain;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {

    @Id // Primary key를 나타냄
    @Column(name="userId")
    private String userId;
    @Column(name="userName")
    private String userName;
    @Column(name="userPw")
    private String userPw;

    @Builder
    public User(String userId,String userName,String userPw) {
        this.userId=userId;
        this.userName=userName;
        this.userPw=userPw;
    }


}
