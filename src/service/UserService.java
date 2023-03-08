package service;

import Requests.LogInRequest;
import Requests.RegisterUserRequest;
import Responses.FindUserResponse;
import data.model.User;

public interface UserService {
    User register(RegisterUserRequest registerRequest);
    User logIn(LogInRequest logInRequest);
    FindUserResponse findUser(int id);
    String deleteUser(int id);
    FindUserResponse findUserByUserName(String  username);
}
