package com.blogapp.myblogapp.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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
public class Comment {
    @Column(name = "CommentID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private User author;
    private String content;
    private int likes;
    @DateTimeFormat
    private LocalDate time;

}
