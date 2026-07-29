package com.Connectly.posts_service.Service;

import com.Connectly.posts_service.Entity.Post;
import com.Connectly.posts_service.Entity.PostLike;
import com.Connectly.posts_service.Repository.PostLikeRepository;
import com.Connectly.posts_service.Repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostLikeService {

    private final PostRepository postRepository;
    private final PostLikeRepository postLikeRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void likePost(Long postId) {
        long userId = 1L;
        Post post = postRepository.findById(postId)
                        .orElseThrow(() -> new RuntimeException("Post not found"));

        boolean isLikedByUser = postLikeRepository.existsByUserIdAndPostId(userId, postId);

        if(isLikedByUser){
            throw new RuntimeException("A post cannot be liked twice");
        }

        PostLike postLike = new PostLike();
        postLike.setUserId(userId);
        postLike.setPostId(postId);

        postLikeRepository.save(postLike);
        //    TODO: send notification to post owner
    }

    @Transactional
    public void unlikePost(Long postId) {
        long userId = 1L;
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        boolean isLikedByUser = postLikeRepository.existsByUserIdAndPostId(userId, postId);

        if(!isLikedByUser){
            throw new RuntimeException("A post cannot be unlike the post.");
        }

        postLikeRepository.deleteByUserIdAndPostId(userId, postId);
        //    TODO: send notification to post owner
    }
}
