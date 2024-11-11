package com.social.media.service;

import com.social.media.entity.Post;
import com.social.media.entity.User;
import com.social.media.repository.PostRepository;
import com.social.media.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PostService postService;


    @Test
    void testCreatePost() {
        User author = new User();
        author.setId(1L);
        author.setUsername("user1");

        Post post = new Post();
        post.setTitle("Test Title");
        post.setContent("Test Body");
        post.setAuthor(author);

        when(userRepository.findById(1L)).thenReturn(Optional.of(author));
        when(postRepository.save(any())).thenReturn(post);

        Post createdPost = postService.create(1L, "Test Title", "Test Body");
        assertNotNull(createdPost);
        assertEquals("Test Title", createdPost.getTitle());
        assertEquals("Test Body", createdPost.getContent());
        assertEquals(author, createdPost.getAuthor());
    }

    @Test
    void testLikePost() {
        User user = new User();
        user.setId(1L);
        user.setUsername("user1");

        Post post = new Post();
        post.setId(1L);
        post.setTitle("Test Title");

        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(postRepository.save(any())).thenReturn(post);

        Post likedPost = postService.likePost(1L, 1L);
        assertNotNull(likedPost);
        assertTrue(likedPost.getLikedBy().contains(user));
    }
}