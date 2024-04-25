package com.example.springmvc.service;

import com.example.springmvc.entity.User;
import com.example.springmvc.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(userId)));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User user) {
        User updateUser = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(userId)));

        updateUser.setName(user.getName());
        updateUser.setEmail(user.getEmail());

        return userRepository.save(updateUser);
    }

    public void deleteUser(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(userId)));
    }
}