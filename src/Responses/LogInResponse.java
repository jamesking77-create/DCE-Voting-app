package Responses;

import java.security.PrivateKey;

public class LogInResponse{
    private String userName;
    private String message;

    @Override
    public String toString() {
        return "LogInResponse{" +
                "userName='" + userName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
