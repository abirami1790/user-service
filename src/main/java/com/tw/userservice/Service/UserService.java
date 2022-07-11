package com.tw.userservice.Service;

import com.tw.userservice.Model.User;
import com.tw.userservice.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(long l){
        List<User> users=new ArrayList<User>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User user(Long userId) {
        return userRepository.findById(userId).get();
    }



}

