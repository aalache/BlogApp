package com.blogapp.myblogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.myblogapp.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
