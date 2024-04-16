package com.blogapp.myblogapp.entities;

import java.security.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BlogId", nullable = false)
    private long id;
    private User author;
    private String title;
    private String content;
    private int likes;
    private Categories categories;
    private List<Comment> comments;
    private Timestamp creationTime;

}
