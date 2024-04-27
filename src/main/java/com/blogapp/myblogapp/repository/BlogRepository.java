package com.blogapp.myblogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.myblogapp.entities.Post;

public interface BlogRepository extends JpaRepository<Post, Long> {

}
