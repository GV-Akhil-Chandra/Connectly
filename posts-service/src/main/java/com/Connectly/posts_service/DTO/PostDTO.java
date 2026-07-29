package com.Connectly.posts_service.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDTO {
    private Long id;
    private String content;
    private Long userId;
    private LocalDateTime creationTimestamp;
}
