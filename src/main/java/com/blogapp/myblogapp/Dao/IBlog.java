package com.blogapp.myblogapp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.myblogapp.entities.Blog;

public interface IBlog extends JpaRepository<Blog, Long> {

}
