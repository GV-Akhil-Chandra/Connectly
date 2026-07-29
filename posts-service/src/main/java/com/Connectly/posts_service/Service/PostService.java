package com.Connectly.posts_service.Service;

import com.Connectly.posts_service.DTO.PostCreationDTO;
import com.Connectly.posts_service.DTO.PostDTO;
import com.Connectly.posts_service.Entity.Post;
import com.Connectly.posts_service.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostDTO createPost(PostCreationDTO postCreationDTO, Long userId) {
        Post post = modelMapper.map(postCreationDTO, Post.class);
        post.setUserId(userId);
        post = postRepository.save(post);
        log.info("Created post with id: {}", post.getId());

        return modelMapper.map(post, PostDTO.class);
    }

    public PostDTO findById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        log.info("Fetching post with id: {}", post.getId());

        return modelMapper.map(post, PostDTO.class);
    }

    public List<PostDTO> findAllUserPosts(Long userId) {
        log.info("Fetching posts for user id: {}", userId);
        List<Post> postList = postRepository.findAllByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User posts not found"));

        return postList.stream()
                .map(e -> modelMapper.map(e, PostDTO.class))
                .toList();
    }
}
