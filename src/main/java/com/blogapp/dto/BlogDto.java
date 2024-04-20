package com.blogapp.dto;

import java.time.LocalDateTime;

import com.blogapp.myblogapp.entities.Bloger;
import com.blogapp.myblogapp.entities.Categories;
import com.blogapp.myblogapp.entities.Visibility;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BlogDto {
    private long id;
    private String title;
    private String content;
    private int likes;
    private Bloger author;
    private Categories categories;
    private Visibility visibility;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;
}
