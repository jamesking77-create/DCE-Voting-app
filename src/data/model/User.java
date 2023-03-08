package data.model;

import java.time.LocalDateTime;
 public class User {
private String firstName;
private String lastName;
private int Id;
private LocalDateTime dateRegistered;
private String userName;
private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getUserId() {
        return Id;
    }

    public void setUserId(int userId) {
        this.Id = userId;
    }

    public LocalDateTime getDateRegistered() {
        return dateRegistered = LocalDateTime.now();
    }

    public void setDateRegistered(LocalDateTime dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

}
