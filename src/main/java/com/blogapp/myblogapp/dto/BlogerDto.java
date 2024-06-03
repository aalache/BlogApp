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
    private String username;
    // ?
    // private String password;
    // ?
    private String email;
    private Role role;
    private List<Post> Posts;
    private List<Comment> comments;
    private List<Bloger> friends;
    private List<Post> favoriteBlogs;
    private List<Post> likedBlogs;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
