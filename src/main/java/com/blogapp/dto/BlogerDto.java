package com.blogapp.dto;

import java.time.LocalDateTime;
import com.blogapp.myblogapp.entities.Blog;
import com.blogapp.myblogapp.entities.Comment;
import lombok.Builder;
import lombok.Data;
import java.util.*;

@Data
@Builder
public class BlogerDto {
    private long id;
    private String userName;
    private String password;
    private String email;
    private List<Blog> blogs;
    private List<Comment> comments;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;
}
