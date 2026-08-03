package com.Connectly.posts_service.Controller;

import com.Connectly.posts_service.Authentication.AuthContextHolder;
import com.Connectly.posts_service.Entity.PostComment;
import com.Connectly.posts_service.Service.PostCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class PostCommentController {
    private final PostCommentService postCommentService;

    @PostMapping("/add/{postId}")
    public ResponseEntity<String> addComment(@RequestBody String comment, @PathVariable Long postId){
        long userId = AuthContextHolder.getCurrentUserId();
        String c = postCommentService.addComment(userId, postId, comment);

        return ResponseEntity.ok(c);
    }

    @GetMapping("/get/{postId}")
    public ResponseEntity<List<PostComment>> getComments(@PathVariable Long postId){
        List<PostComment> list = postCommentService.getComments(postId);

        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }


    @PostMapping("/delete/{postId}/{commentId}")
    public ResponseEntity<Boolean> deleteComment(@RequestBody String comment,
                                                @PathVariable Long postId,
                                                @PathVariable Long commentId){
        long userId = AuthContextHolder.getCurrentUserId();
        boolean c = postCommentService.deleteComment(userId, postId, commentId);

        return ResponseEntity.ok(c);
    }
}
