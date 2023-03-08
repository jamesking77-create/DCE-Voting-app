package data.repository;

import data.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepositoryImpl implements UserRepository {
    private int count;
    private final List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        boolean userHaveNotBeenSaved = user.getUserId() == 0;
        if (userHaveNotBeenSaved) {
            saveNewUser(user);
            users.add(user);
            count++;
        }
        return user;
    }

    private void saveNewUser(User user) {
        user.setUserId(generateId());
    }

    private int generateId() {
        return count+1;
    }

    @Override
    public User findById(int id) {
        for (User user : users ) {
            if (user.getUserId()==id)
                return user;
        }
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void deleteByUser(User user) {
        for (User user1 : users) {
            if (user.equals(user1)){
                users.remove(user);
                count--;
                break;
            }
        }
    }

    @Override
    public void deleteById(int id) {
        for (User user2: users) {
            if (user2.getUserId() == id){
                users.remove(user2);
                count--;
                break;
            }
        }
    }

    @Override
    public void deleteAll() {
        users.removeAll(users);
        count = users.size();

    }

    @Override
    public User findByUserName(String username) {
        for (User user: users){
            if (Objects.equals(username, user.getUserName())){
                return user;
            }
        }
        return null;
    }
}
