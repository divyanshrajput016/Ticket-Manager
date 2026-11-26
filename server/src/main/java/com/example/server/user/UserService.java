package com.example.server.user;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service 
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository , PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email Already Exist");
        }

        if(userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username Already Exist");
        }

        user.setPassword(
            passwordEncoder.encode(user.getPassword())
        );

        return userRepository.save(user);
    }
}
