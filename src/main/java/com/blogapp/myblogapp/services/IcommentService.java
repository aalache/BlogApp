package com.blogapp.myblogapp.services;

import com.blogapp.myblogapp.dto.CommentDto;
import com.blogapp.myblogapp.entities.Comment;

public interface IcommentService {

    CommentDto createComment(Comment comment);

    CommentDto saveComment(Comment comment);

    CommentDto updateComment(Comment comment);

    void deleteComment(Long commentId);
}
