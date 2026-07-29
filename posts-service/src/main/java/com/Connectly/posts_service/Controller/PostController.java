package com.Connectly.posts_service.Controller;

import com.Connectly.posts_service.DTO.PostCreationDTO;
import com.Connectly.posts_service.DTO.PostDTO;
import com.Connectly.posts_service.Service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create-post")
    public ResponseEntity<PostDTO> createCost(@RequestBody PostCreationDTO postCreationDTO,
                                              HttpServletRequest httpServletRequest){
        PostDTO postDTO = postService.createPost(postCreationDTO, 1L);
        return new ResponseEntity<>(postDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable(name = "postId") Long postId){
        PostDTO postDTO = postService.findById(postId);
        return new ResponseEntity<>(postDTO, HttpStatus.FOUND);
    }

    @GetMapping("/users/{userId}/posts")
    public ResponseEntity<List<PostDTO>> getAllUserPosts(@PathVariable Long userId){
        List<PostDTO> postDTOList = postService.findAllUserPosts(userId);

        return new ResponseEntity<>(postDTOList, HttpStatus.FOUND);
    }
}
