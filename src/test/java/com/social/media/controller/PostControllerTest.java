package com.social.media.controller;

import com.social.media.entity.Post;
import com.social.media.entity.User;
import com.social.media.service.PostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {

    @Mock
    private PostService postService;

    @InjectMocks
    private PostController postController;

    @Test
    void testCreatePost() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Test Title");
        post.setContent("Test Content");

        when(postService.create(1L, "Test Title", "Test Body")).thenReturn(post);

        Map<String, String> request = new HashMap<>();
        request.put("title", "Test Title");
        request.put("content", "Test Body");

        ResponseEntity<Post> response = postController.create(1L, request);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Test Title", response.getBody().getTitle());
        assertEquals("Test Content", response.getBody().getContent());
    }

    @Test
    void testLikePost() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Test Title");

        when(postService.likePost(1L, 1L)).thenReturn(post);

        ResponseEntity<Post> response = postController.like(1L, 1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
    }

    @Test
    void testGetPostsByAuthor() {
        User author = new User();
        author.setId(1L);
        author.setUsername("user1");

        Post post1 = new Post();
        post1.setTitle("Post 1");
        post1.setContent("Body 1");
        post1.setAuthor(author);

        Post post2 = new Post();
        post2.setTitle("Post 2");
        post2.setContent("Body 2");
        post2.setAuthor(author);

        List<Post> posts = List.of(post1, post2);

        when(postService.getByAuthor(1L)).thenReturn(posts);

        ResponseEntity<List<Post>> response = postController.getByAuthor(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
        assertEquals("Post 1", response.getBody().get(0).getTitle());
    }
}