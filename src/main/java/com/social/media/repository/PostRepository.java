package com.social.media.repository;

import com.social.media.entity.Post;
import com.social.media.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByAuthor(User author);
}
