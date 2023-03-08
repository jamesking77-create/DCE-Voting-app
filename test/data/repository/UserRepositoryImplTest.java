package data.repository;

import data.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private UserRepository userRepository;
    private User user;
    private User user2;

    @BeforeEach
    public void setUp(){
        userRepository = new UserRepositoryImpl();
        user = new User();
        user.setFirstName("james");
        user.setLastName("king");
        user.setUserName("jamesKing77");
        user.setPassword("0909");

        user2 = new User();
        user.setFirstName("prof");
        user.setLastName("olakunle");
        user.setUserName("prof123");
        user.setPassword("0808");

    }
    @Test
    public void saveOneUser_CountIsOneTest(){
        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }
    @Test public void saveOneUser_IdOfUserIsOneTest(){
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getUserId());
    }
    @Test public void saveTwoUserWithSameId_counterIsOneTest(){
        userRepository.save(user);
        user.setLastName("kings");
        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }
    @Test public void saveOneUser_FindOneUserByIdTest(){
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getUserId());
        User foundUser = userRepository.findById(1);
        assertEquals(foundUser, savedUser);
    }
    @Test public void saveTwoUser_findAllUserTest(){
        userRepository.save(user);
        userRepository.save(user2);
        assertEquals(1, user.getUserId());
        assertEquals(2,user2.getUserId());
        userRepository.findAll();
        assertEquals(2, userRepository.findAll().size());
    }
    @Test public void  saveOneUser_deleteOneUserByUserTest(){
        userRepository.save(user);
        userRepository.save(user2);
        assertEquals(2, userRepository.count());
        userRepository.deleteByUser(user);
        assertEquals(1, userRepository.count());
    }
    @Test public void saveTwoUser_deleteOneUserByIdTest(){
        userRepository.save(user);
        userRepository.save(user2);
        assertEquals(2, userRepository.count());
        userRepository.deleteById(1);
        assertEquals(1, userRepository.count());
    }
    @Test public void saveTwoUser_deleteAllUsersTest(){
        userRepository.save(user);
        userRepository.save(user2);
        assertEquals(2, userRepository.count());
        userRepository.deleteAll();
        assertEquals(0, userRepository.count());
    }

    @Test public void saveTwoUser_findUserByUserNameTest(){
        User firstUser = userRepository.save(user);
        assertEquals(1, firstUser.getUserId());
        User secondUser = userRepository.save(user2);
        assertEquals(2, secondUser.getUserId());
        User foundUser =  userRepository.findByUserName(user2.getUserName());
        assertEquals(secondUser, foundUser);


    }

}