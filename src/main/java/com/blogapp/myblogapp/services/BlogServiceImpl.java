package com.blogapp.myblogapp.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.myblogapp.dto.BlogDto;
import com.blogapp.myblogapp.entities.Post;
import com.blogapp.myblogapp.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<BlogDto> findAllBlogs() {
        List<Post> blogs = blogRepository.findAll();
        return blogs.stream().map((blog) -> mapToBlogDto(blog)).collect(Collectors.toList());
    }

    private BlogDto mapToBlogDto(Post blog) {
        BlogDto blogDto = BlogDto.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .author(blog.getAuthor())
                .categories(blog.getCategories())
                .comments(blog.getComments())
                .createdOn(blog.getCreatedOn())
                .updateOn(blog.getUpdateOn())
                .build();
        return blogDto;
    }
}
