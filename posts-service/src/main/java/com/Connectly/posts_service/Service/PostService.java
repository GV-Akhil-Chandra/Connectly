package com.Connectly.posts_service.Service;

import com.Connectly.posts_service.DTO.PostCreationDTO;
import com.Connectly.posts_service.DTO.PostDTO;
import com.Connectly.posts_service.Entity.Post;
import com.Connectly.posts_service.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
