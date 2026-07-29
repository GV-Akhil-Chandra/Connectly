package com.Connectly.posts_service.Repository;

import com.Connectly.posts_service.Entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    boolean existsByUserId(Long userId);

    boolean existsByUserIdAndPostId(long userId, long postId);

    void deleteByUserIdAndPostId(long userId, Long postId);
}
