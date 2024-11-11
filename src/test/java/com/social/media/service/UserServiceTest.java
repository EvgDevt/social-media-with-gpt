package com.social.media.service;

import com.social.media.entity.User;
import com.social.media.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testFollowUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("user1");

        User follower = new User();
        follower.setId(2L);
        follower.setUsername("user2");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.findById(2L)).thenReturn(Optional.of(follower));
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userService.followUser(1L, 2L);
        assertNotNull(result);
        assertTrue(result.getFollowers().contains(follower));
        verify(userRepository, times(1)).save(user);
    }

}