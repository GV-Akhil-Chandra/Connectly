package com.Connectly.posts_service.Service;

import com.Connectly.posts_service.Entity.PostComment;
import com.Connectly.posts_service.Repository.PostCommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostCommentService {
    private final PostCommentRepository postCommentRepository;
    private final ModelMapper modelMapper;

    public String addComment(Long userId, Long postId, String comment){
        PostComment pc = PostComment.builder()
                .content(comment)
                .userId(userId)
                .postId(postId)
                .build();

        pc = postCommentRepository.save(pc);

        return pc.getContent();
    }

    public Boolean deleteComment(long userId, Long postId, Long id) {
        PostComment pc = PostComment.builder()
                .id(id)
                .userId(userId)
                .postId(postId)
                .build();

        postCommentRepository.delete(pc);

        return true;
    }

    public List<PostComment> getComments(Long postId) {
        return postCommentRepository.findAllByPostId(postId);
    }
}
