package com.blogapp.myblogapp.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {

    private long id;
    private String content;
    private int likes;
    private BlogerDto author;
    private PostDto blog;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
