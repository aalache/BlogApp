package com.blogapp.myblogapp.services;

import com.blogapp.myblogapp.dto.BlogerDto;
import com.blogapp.myblogapp.entities.User;

public interface IBlogerService {

    void friendRequest();

    BlogerDto createPost(User user);

    BlogerDto savePost(User user);

    Boolean updatePost(User user);

    Boolean deletePost(Long userId);
}
