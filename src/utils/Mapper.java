package utils;

import Requests.LogInRequest;
import Requests.RegisterUserRequest;
import Responses.FindUserResponse;
import Responses.LogInResponse;
import data.model.User;

import java.time.format.DateTimeFormatter;

public class Mapper {
    public static User map(RegisterUserRequest registerRequest) {
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setUserName(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        return user;
    }

    public static void map(User foundUser, FindUserResponse response){
        response.setFullName(foundUser.getFirstName()+ " " + foundUser.getLastName());
        response.setUserId(foundUser.getUserId());
        response.setUsername(foundUser.getUserName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd/MM/yyyy, hh:mm a");
        response.setDateRegistered(formatter.format(foundUser.getDateRegistered()));
    }

    public static User map(LogInRequest logInRequest){
        User user = new User();
        user.setUserName(logInRequest.getUsername());
        return user;
    }
    public static void map(User foundUser, LogInResponse response){
        response.setUserName(foundUser.getUserName());
        response.setMessage("WELCOME TO PVM");
    }
}
