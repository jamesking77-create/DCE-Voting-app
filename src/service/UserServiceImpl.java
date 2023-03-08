package service;

import Requests.LogInRequest;
import Requests.RegisterUserRequest;
import Responses.FindUserResponse;
import data.model.User;
import data.repository.UserRepository;
import data.repository.UserRepositoryImpl;
import utils.Mapper;
import java.util.NoSuchElementException;


public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public User register(RegisterUserRequest registerRequest) {
        if (userExist(registerRequest.getUsername())) throw new IllegalArgumentException(registerRequest.getUsername() + " already exists");
        return userRepository.save(Mapper.map(registerRequest));
    }

    @Override
    public User logIn(LogInRequest logInRequest) {
        boolean userHasNotRegistered = !logInRequest.getUsername().equals(userRepository.findByUserName(logInRequest.getUsername()).getUserName()) || !logInRequest.getPassword().equals(userRepository.findByUserName(logInRequest.getUsername()).getPassword());
        if (userHasNotRegistered) throw new IllegalArgumentException("invalid information");
        return userRepository.findByUserName(Mapper.map(logInRequest).getUserName());
    }

    private boolean userExist(String username) {
        User foundUser = userRepository.findByUserName(username);
        return foundUser != null;
    }

    @Override
    public FindUserResponse findUser(int id) {
        FindUserResponse userResponse = new FindUserResponse();
        User foundUser = userRepository.findById(id);
        if (foundUser == null) throw new NoSuchElementException("user doesn't exist");
        Mapper.map(foundUser, userResponse);
        return userResponse;
    }

    @Override
    public String deleteUser(int id) {
        if (id == userRepository.findById(id).getUserId()) {
            userRepository.deleteById(id);
            return "User successfully deleted";
        }
        return null;
    }

    @Override
    public FindUserResponse findUserByUserName(String userName) {
        FindUserResponse userResponse = new FindUserResponse();
        User foundUser = userRepository.findByUserName(userName);
        if (foundUser == null) throw new NoSuchElementException("user doesn't exist");
        Mapper.map(foundUser, userResponse);
        return userResponse;
    }
}
