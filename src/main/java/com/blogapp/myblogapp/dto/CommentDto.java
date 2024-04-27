package com.blogapp.myblogapp.dto;

import java.time.LocalDateTime;
import com.blogapp.myblogapp.entities.Post;
import com.blogapp.myblogapp.entities.Bloger;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {

    private long id;
    private String content;
    private int likes;
    private Bloger author;
    private Post blog;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
