package com.blogapp.myblogapp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.myblogapp.entities.Comment;

public interface IComment extends JpaRepository<Comment, Long> {

}
