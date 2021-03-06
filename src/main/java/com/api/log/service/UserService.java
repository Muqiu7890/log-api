package com.api.log.service;

import com.api.log.LogRepository.UserRepository;
import com.api.log.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllFollowedUser(Integer id){
        return userRepository.findAllFollowedUserById(id);
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public List<User> findByName(String name) {
        return userRepository.findByNameLike("%" + name + "%");
    }
}
