package com.blogapp.myblogapp.services;

import java.util.List;

import com.blogapp.myblogapp.dto.BlogDto;

public interface BlogService {
    List<BlogDto> findAllBlogs();
}
