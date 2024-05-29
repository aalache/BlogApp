package com.blogapp.myblogapp.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.blogapp.myblogapp.entities.*;
import lombok.*;

@Data
@Builder
public class PostDto {
    private long id;
    private String title;
    private String description;
    private String content;
    private int likes;
    private Bloger author;
    private List<Comment> comments;
    private Categorie categorie;
    private Visibility visibility;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
