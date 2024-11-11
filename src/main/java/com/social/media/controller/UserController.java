package com.social.media.controller;

import com.social.media.entity.User;
import com.social.media.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{followUserId}")
    public ResponseEntity<User> followUser(@PathVariable Long userId,
                                           @PathVariable Long followUserId) {
        return ResponseEntity.ok(userService.followUser(userId, followUserId));
    }
}
