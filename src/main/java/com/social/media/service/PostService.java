package com.social.media.service;

import com.social.media.entity.Post;
import com.social.media.entity.User;
import com.social.media.repository.PostRepository;
import com.social.media.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Post create(Long userId, String title, String content) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setAuthor(user);
        return postRepository.save(post);
    }

    public Post likePost(Long postId, Long userId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        post.getLikedBy().add(user);
        return postRepository.save(post);
    }

    public List<Post> getByAuthor(Long userId) {
        User author = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return postRepository.findByAuthor(author);
    }
}
