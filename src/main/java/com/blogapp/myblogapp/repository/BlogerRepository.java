package com.blogapp.myblogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.myblogapp.entities.Bloger;

public interface BlogerRepository extends JpaRepository<Bloger, Long> {

}
