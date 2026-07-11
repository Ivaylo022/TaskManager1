package com.ivaylo.taskmanager.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.ivaylo.taskmanager.entity.User;
import com.ivaylo.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User register(User user) {

        user.setPassword(
                encoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
    public User login(String username, String password) {

        User user = userRepository.findByUsername(username)
                .orElse(null);

        if (user == null) {
            return null;
        }

        if (!encoder.matches(password, user.getPassword())) {
            return null;
        }

        return user;
    }
}