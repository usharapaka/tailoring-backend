package com.tailoring.service;

import com.tailoring.entity.User;
import com.tailoring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User updateUser(Long id, User user) {
    User existingUser = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    existingUser.setName(user.getName());
    existingUser.setPhone(user.getPhone());
    existingUser.setEmail(user.getEmail());

    return userRepository.save(existingUser);
}

public void deleteUser(Long id) {
    userRepository.deleteById(id);
}
}