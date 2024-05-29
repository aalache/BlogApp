package com.blogapp.myblogapp.services;

import java.time.LocalDateTime;
import java.util.List;

import com.blogapp.myblogapp.dto.PostDto;
import com.blogapp.myblogapp.entities.Bloger;
import com.blogapp.myblogapp.entities.Categorie;
import com.blogapp.myblogapp.entities.Post;
import com.blogapp.myblogapp.entities.Visibility;

public interface IpostService {

    // ? post filters

    List<PostDto> findAllPosts();

    PostDto findById(Long postId);

    List<PostDto> findByAuthor(Bloger author);

    List<PostDto> findByCategorie(Categorie categorie);

    List<PostDto> findByTitle(String title);

    List<PostDto> findByVisibility(Visibility visibility);

    List<PostDto> findByCreatedOn(LocalDateTime createdOn);

    // ? post Crud operations

    Boolean likePost(Long postId);

    PostDto createPost(Post post);

    PostDto savePost(Post post);

    Boolean updatePost(Post post);

    Boolean deletePost(Long postId);

}
