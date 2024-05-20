package com.blogapp.myblogapp.dto;

import com.blogapp.myblogapp.entities.Bloger;
import com.blogapp.myblogapp.entities.Comment;
import com.blogapp.myblogapp.entities.Post;
import com.blogapp.myblogapp.entities.User;

public class DtoMapping {

    // ? mapping from post to PostDto

    public PostDto mapToPostDto(Post post) {

        PostDto postDto = PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .likes(post.getLikes())
                .author(post.getAuthor())
                .categorie(post.getCategorie())
                .comments(post.getComments())
                .createdOn(post.getCreatedOn())
                .updatedOn(post.getUpdatedOn())
                .build();
        return postDto;

    }

    // ? mapping from PostDto to Post

    public Post mapToPost(PostDto post) {

        Post postRes = Post.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .likes(post.getLikes())
                .author(post.getAuthor())
                .categorie(post.getCategorie())
                .comments(post.getComments())
                .createdOn(post.getCreatedOn())
                .updatedOn(post.getUpdatedOn())
                .build();
        return postRes;

    }

    // ? mapping from Comment to CommentDto

    public CommentDto mapToCommentDto(Comment comment) {

        CommentDto commentDto = CommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .likes(comment.getLikes())
                .author(mapToBlogerDto(comment.getAuthor()))
                .content(comment.getContent())
                .blog(mapToPostDto(comment.getPost()))
                .createdOn(comment.getCreatedOn())
                .updatedOn(comment.getUpdatedOn())
                .build();

        return commentDto;

    }

    // ? mapping from CommentDto to Comment

    public Comment mapToComment(CommentDto comment) {

        Comment commentRes = Comment.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .likes(comment.getLikes())
                .author(mapToBloger(comment.getAuthor()))
                .content(comment.getContent())
                .post(mapToPost(comment.getBlog()))
                .createdOn(comment.getCreatedOn())
                .updatedOn(comment.getUpdatedOn())
                .build();

        return commentRes;

    }

    // ? mapping from Bloger to BlogerDto

    public BlogerDto mapToBlogerDto(Bloger user) {

        BlogerDto blogerDto = BlogerDto.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .role(user.getRole())
                .Posts(user.getPosts())
                .comments(user.getComments())
                .friends(user.getFriends())
                .favoriteBlogs(user.getFavoriteBlogs())
                .likedBlogs(user.getLikedBlogs())
                .createdOn(user.getCreatedOn())
                .updatedOn(user.getUpdatedOn())
                .build();

        return blogerDto;
    }

    // ? mapping from BlogerDto to Bloger

    public Bloger mapToBloger(BlogerDto user) {

        Bloger blogerRes = Bloger.builder()
                .Posts(user.getPosts())
                .comments(user.getComments())
                .friends(user.getFriends())
                .favoriteBlogs(user.getFavoriteBlogs())
                .likedBlogs(user.getLikedBlogs())
                .createdOn(user.getCreatedOn())
                .updatedOn(user.getUpdatedOn())
                .build();

        blogerRes.setId(user.getId());
        blogerRes.setUserName(user.getUserName());
        blogerRes.setEmail(user.getEmail());
        blogerRes.setRole(user.getRole());

        return blogerRes;
    }

}
