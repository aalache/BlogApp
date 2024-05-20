package com.blogapp.myblogapp.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "blogers")
@DiscriminatorValue("BLG")
public class Bloger extends User {

    public Bloger() {
        this.setRole(Role.ROLE_BLOGER);
    }

    public Bloger(String username, String password) {
        super(username, password);
        this.setRole(Role.ROLE_BLOGER);
    }

    public Bloger(String username, String password, String email) {
        super(username, password, email);
        this.setRole(Role.ROLE_BLOGER);
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "author")
    private List<Post> Posts;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "author")
    private List<Comment> comments;

    @OneToMany
    private List<Bloger> friends;

    @OneToMany
    private List<Post> favoriteBlogs;

    @OneToMany
    private List<Post> likedBlogs;

    @OneToMany
    private List<Bloger> friendRequest;

    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;

}