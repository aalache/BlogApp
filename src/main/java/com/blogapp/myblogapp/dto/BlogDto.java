package com.blogapp.myblogapp.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.blogapp.myblogapp.entities.*;
import lombok.*;

@Data
@Builder
public class BlogDto {

    private long id;
    private String title;
    private String content;
    private int likes;
    private Bloger author;
    private List<Comment> comments;
    private Categories categories;
    private Visibility visibility;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;

}
