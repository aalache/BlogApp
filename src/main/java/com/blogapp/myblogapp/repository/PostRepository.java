package com.blogapp.myblogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.myblogapp.entities.Bloger;
import com.blogapp.myblogapp.entities.Categorie;
import com.blogapp.myblogapp.entities.Post;
import com.blogapp.myblogapp.entities.Visibility;

import java.util.List;
import java.time.LocalDateTime;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findById(long id);

    List<Post> findByAuthor(Bloger author);

    List<Post> findByCategorie(Categorie categorie);

    List<Post> findByTitle(String title);

    List<Post> findByVisibility(Visibility visibility);

    List<Post> findByCreatedOn(LocalDateTime createdOn);
}
