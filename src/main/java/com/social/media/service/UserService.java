package com.social.media.service;

import com.social.media.entity.User;
import com.social.media.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User followUser(Long userId, Long followUserId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        User userToFollow = userRepository.findById(followUserId).orElseThrow(() -> new RuntimeException("User not found"));
        user.getFollowers().add(userToFollow);
        return userRepository.save(user);
    }
}
