package com.blogapp.myblogapp.entities;

import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.nimbusds.jose.util.Base64;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "posts")
// @ToString(exclude = "author")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PostId", nullable = false)
    private long id;

    @NotEmpty(message = "title can't be empty")
    private String title;

    @NotEmpty(message = "description can't be empty")
    @Size(max = 255)
    @Column(length = 255)
    private String description;

    @NotEmpty(message = "image link can't be empty")
    @Column(name = "PostImage")
    private String image;

    @NotEmpty(message = "content can't be empty")
    @Column(columnDefinition = "Text")
    private String content;

    private int likes;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Bloger author;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "post")
    private List<Comment> comments;

    @Enumerated(EnumType.STRING)
    @Column(name = "categories", nullable = false)
    private Categorie categorie;

    @Enumerated(EnumType.STRING)
    @Column(name = "visibility", nullable = false)
    private Visibility visibility;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime updatedOn;

}
