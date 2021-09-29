package com.example.testTask2.service;

import com.example.testTask2.exception.ResourceNotFoundException;
import com.example.testTask2.exception.UserAlreadyExistException;
import com.example.testTask2.model.User;
import com.example.testTask2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registration(User user) {
        if (userRepository.findByLogin(user.getLogin())  != null) {
            try {
                throw new UserAlreadyExistException("User with this login exists");
            } catch (UserAlreadyExistException e) {
                e.printStackTrace();
            }
        }
        if (userRepository.findByPassword(user.getPassword())  != null) {
            try {
                throw new UserAlreadyExistException("User with this password exists");
            } catch (UserAlreadyExistException e) {
                e.printStackTrace();
            }
        }
        return this.userRepository.save(user);
    }

    public User findById(long userId) {
        User user = userRepository.findById(userId).get();
        if (user == null) {
            try {
                throw new ResourceNotFoundException("User did not find.");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        if (users == null) {
            try {
                throw new ResourceNotFoundException("Users did not find.");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    public void delete(long userId) {
        userRepository.delete(findById(userId));
    }

    public User update(User user, long userId) {
        User existing = findById(userId);

        existing.setFirstName(user.getFirstName());
        existing.setLastName(user.getLastName());
        existing.setDateBirth(user.getDateBirth());
        existing.setLogin(user.getLogin());
        existing.setPassword(user.getPassword());
        existing.setAboutMySelf(user.getAboutMySelf());
        existing.setAddressResidence(user.getAddressResidence());
        return userRepository.save(existing);
    }
}
