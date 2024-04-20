package com.blogapp.myblogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.myblogapp.entities.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}
