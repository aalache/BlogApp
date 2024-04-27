package com.blogapp.myblogapp.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.blogapp.myblogapp.entities.*;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BlogerDto {

    private long id;
    private String userName;
    private String password;
    private String email;
    private List<Post> blogs;
    private List<Comment> comments;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
