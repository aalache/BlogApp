package com.blogapp.myblogapp.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private PostDto mapToPostDto(Post blog) {
        PostDto postDto = PostDto.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .author(blog.getAuthor())
                .categorie(blog.getCategorie())
                .comments(blog.getComments())
                .createdOn(blog.getCreatedOn())
                .updatedOn(blog.getUpdatedOn())
                .build();
        return postDto;
    }

    // ? All search filters By [id,author,categorie,title,visibility,creationTime]

    @Override
    public List<PostDto> findAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map((post) -> mapToPostDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto findById(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        return mapToPostDto(post);
    }

    @Override
    public List<PostDto> findByAuthor(Bloger author) {
        List<Post> posts = postRepository.findByAuthor(author);
        return posts.stream().map((post) -> mapToPostDto(post)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findByCategorie(Categorie categorie) {
        List<Post> posts = postRepository.findByCategorie(categorie);
        return posts.stream().map((post) -> mapToPostDto(post)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findByTitle(String title) {
        List<Post> posts = postRepository.findByTitle(title);
        return posts.stream().map((post) -> mapToPostDto(post)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findByVisibility(Visibility visibility) {
        List<Post> posts = postRepository.findByVisibility(visibility);
        return posts.stream().map((post) -> mapToPostDto(post)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findByCreatedOn(LocalDateTime createdOn) {
        List<Post> posts = postRepository.findByCreatedOn(createdOn);
        return posts.stream().map((post) -> mapToPostDto(post)).collect(Collectors.toList());
    }

    // ? This function show how to update post likes afeter a like event

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

        // Post newPost = Post.builder()
        // .id(post.getId())
        // .author(post.getAuthor())
        // .categorie(post.getCategorie())
        // .comments(post.getComments())
        // .content(post.getContent())
        // .createdOn(post.getCreatedOn())
        // .updatedOn(post.getUpdatedOn())
        // .likes(post.getLikes())
        // .build();

        return savePost(post);

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
        if (post != null) {
            return mapToPostDto(postRepository.save(post));
        }
        return null;
    }

    @Override
    public Boolean updatePost(Post post) {
        Post postToUpdate = postRepository.findById(post.getId());

        if (postToUpdate != null) {
            savePost(post);
            return true;

        } else {
            createPost(post);
            return false;
        }
    }

}
