package com.blogapp.myblogapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.blogapp.myblogapp.dto.CommentDto;
import com.blogapp.myblogapp.dto.DtoMapping;
import com.blogapp.myblogapp.entities.Comment;
import com.blogapp.myblogapp.repository.CommentRepository;

public class CommentServiceImpl implements IcommentService {

    @Autowired
    private CommentRepository commentRepository;

    private DtoMapping dtoMapping;

    public CommentServiceImpl() {
        dtoMapping = new DtoMapping();
    }

    @Override
    public CommentDto createComment(Comment comment) {

        return saveComment(comment);

    }

    @Override
    public CommentDto saveComment(Comment comment) {
        Comment commentRes = commentRepository.save(comment);
        return dtoMapping.mapToCommentDto(commentRes);
    }

    @Override
    public CommentDto updateComment(Comment comment) {

        return dtoMapping.mapToCommentDto(commentRepository.save(comment));

    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

}
