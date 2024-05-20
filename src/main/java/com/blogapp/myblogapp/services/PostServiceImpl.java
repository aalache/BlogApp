package com.blogapp.myblogapp.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.myblogapp.dto.DtoMapping;
import com.blogapp.myblogapp.dto.PostDto;
import com.blogapp.myblogapp.entities.Bloger;
import com.blogapp.myblogapp.entities.Categorie;
import com.blogapp.myblogapp.entities.Post;
import com.blogapp.myblogapp.entities.Visibility;
import com.blogapp.myblogapp.repository.PostRepository;

@Service
public class PostServiceImpl implements IpostService {
    @Autowired
    private PostRepository postRepository;

    private DtoMapping dtoMapping;

    public PostServiceImpl() {
        dtoMapping = new DtoMapping();
    }

    // ? All search filters By [id,author,categorie,title,visibility,creationTime]

    @Override
    public List<PostDto> findAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map((post) -> dtoMapping.mapToPostDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto findById(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        return dtoMapping.mapToPostDto(post);
    }

    @Override
    public List<PostDto> findByAuthor(Bloger author) {
        List<Post> posts = postRepository.findByAuthor(author);
        return posts.stream().map((post) -> dtoMapping.mapToPostDto(post)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findByCategorie(Categorie categorie) {
        List<Post> posts = postRepository.findByCategorie(categorie);
        return posts.stream().map((post) -> dtoMapping.mapToPostDto(post)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findByTitle(String title) {
        List<Post> posts = postRepository.findByTitle(title);
        return posts.stream().map((post) -> dtoMapping.mapToPostDto(post)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findByVisibility(Visibility visibility) {
        List<Post> posts = postRepository.findByVisibility(visibility);
        return posts.stream().map((post) -> dtoMapping.mapToPostDto(post)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findByCreatedOn(LocalDateTime createdOn) {
        List<Post> posts = postRepository.findByCreatedOn(createdOn);
        return posts.stream().map((post) -> dtoMapping.mapToPostDto(post)).collect(Collectors.toList());
    }

    // ? This function show how to update post likes after a like event

    @Override
    public Boolean likePost(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        if (post != null) {
            post.setLikes(post.getLikes() + 1);
            postRepository.save(post);
            return true;
        }
        return false;
    }

    // ? Crud operations

    @Override
    public PostDto createPost(Post post) {

        if (post != null)
            return savePost(post);
        else
            return null;

    }

    @Override
    public Boolean deletePost(Long postId) {

        if (postId != null) {
            postRepository.deleteById(postId);
            return true;
        }
        return false;
    }

    @Override
    public PostDto savePost(Post post) {

        Post savedPost = postRepository.save(post);
        return dtoMapping.mapToPostDto(savedPost);

    }

    @Override
    public Boolean updatePost(Post post) {

        Post postToUpdate = postRepository.findById(post.getId());

        if (postToUpdate != null) {
            savePost(post);
            return true;

        } else {
            return false;
        }
    }

}
