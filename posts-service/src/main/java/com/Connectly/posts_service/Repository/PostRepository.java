package com.Connectly.posts_service.Repository;

import com.Connectly.posts_service.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long > {
    Optional<List<Post>> findAllByUserId(Long userId);
}
