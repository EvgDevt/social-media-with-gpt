package com.social.media.controller;

import com.social.media.entity.Post;
import com.social.media.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Post> create(@PathVariable Long userId, @RequestBody Map<String, String> request) {
        String title = request.get("title");
        String content = request.get("content");

        return ResponseEntity.ok(postService.create(userId, title, content));
    }

    @PostMapping("/{postId}/like/{userId}")
    public ResponseEntity<Post> like(@PathVariable Long postId, @PathVariable Long userId) {
        return ResponseEntity.ok(postService.likePost(postId, userId));
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Post>> getByAuthor(@PathVariable Long authorId) {
        return ResponseEntity.ok(postService.getByAuthor(authorId));
    }
}
