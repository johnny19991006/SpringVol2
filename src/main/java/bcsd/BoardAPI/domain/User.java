package bcsd.BoardAPI.domain;

public class User {
    private String userId;
    private String userName;
    private String userEmail;
    private String userPassword;

    public User() {
        super();
        this.userId = "";
        this.userName = "";
        this.userEmail = "";
        this.userPassword = "";
    }

    public User(String userId, String userName, String userEmail, String userPassword) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}